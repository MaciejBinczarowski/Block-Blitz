
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;

public class GameDirector extends Thread
{
    private GameRender gameRender;
    private Figure activeFigure;
    private Block[][] gridArray = new Block[Settings.getRows()][Settings.getColumns()];
    private final GridPane gridPane;
    private final Object mutex;
    private int rowsArragmentChanged = 0;
    private ArrayList<Block[]> removedRows = new ArrayList<Block[]>();
    private int score = 0;

    public GameDirector(GridPane gridPane, Object mutex)
    {
        this.gameRender = new GameRender(gridPane, mutex);
        this.gridPane = gridPane;
        this.activeFigure = getRandomFigure();
        this.mutex = mutex;
        setEvents();
        gameRender.renderFigure(activeFigure);
    }

    private void setEvents()
    {
        System.out.println("Setuje event");
        gridPane.getScene().setOnKeyPressed(event ->
        {
            // System.out.println("Tutaj też je setuje");
            if (event.getCode() == KeyCode.DOWN)
            {
                synchronized(mutex)
                {
                    System.out.println("kliknięto downa");
                    if (!checkCollision("down"))
                    {
                        activeFigure.moveDown();
                        gameRender.renderFigure(activeFigure);
                        score += 100;
                    }
                }
            }

            if (event.getCode() == KeyCode.RIGHT)
            {   
                synchronized(mutex)
                {
                    if (!checkCollision("right"))
                    {
                        activeFigure.moveRight();
                        gameRender.renderFigure(activeFigure);
                    }
                }
            }

            if (event.getCode() == KeyCode.LEFT)
            { 
                synchronized(mutex)
                {
                    if (!checkCollision("left"))
                    {
                        activeFigure.moveLeft();
                        gameRender.renderFigure(activeFigure);
                    }
                }
            } 

            if (event.getCode() == KeyCode.SPACE)
            {
                synchronized(mutex)
                {
                    if (!checkRotateCollision())
                    {
                        activeFigure.rotate();
                        gameRender.renderFigure(activeFigure);
                    }
                }
            }
             
        });
    }

    public Figure getRandomFigure()
    {
        Figure[] figures = {new IFigure(), new TFigure(), new OFigure(), new LFigure(), new JFigure(), new SFigure(), new ZFigure()};
        return figures[(int) (System.currentTimeMillis() % figures.length)];
    }

    private boolean checkCollision(String direction)
    {
        int nextColumn = 0;
        int nextRow = 0;
        if (direction.equals("down"))
        {
            nextColumn = 0;
            nextRow = 1;  
        }

        if (direction.equals("right"))
        {
            nextColumn = 1;
            nextRow = 0;
        }

        if (direction.equals("left"))
        {
            nextColumn = -1;
            nextRow = 0;
        }

        for (Block block : activeFigure.getBlocks()) 
        {
            int checkedRow = block.getRow() + nextRow;
            int checkedColumn = block.getColumn() + nextColumn;
            System.out.println(checkedRow);
            if (checkedRow >= Settings.getRows() || checkedColumn >= Settings.getColumns() || checkedColumn < 0)
            {
                return true;
            }

            if (gridArray[checkedRow][checkedColumn] != null || gridArray[checkedRow][checkedColumn] != null)
            {
                return true;
            }
        }

        return false;
    }

    private boolean checkRotateCollision()
    {
        Figure helpCopyOfFigure = new FigureCopy(activeFigure, activeFigure.copyBlocks()); // chuj a nie kopia, jak mogę zrobić kopię ??? // dajcie mi internet!!
        helpCopyOfFigure.rotate();

        for (Block block : helpCopyOfFigure.getBlocks()) 
        {
            int newRow = block.getRow();
            int newColumn = block.getColumn();

            if (newRow < 0 || newColumn < 0 || newRow >= Settings.getRows() || newColumn >= Settings.getColumns())
            {
                return true;
            }

            if (gridArray[newRow][newColumn] != null)
            {
                return true;
            }
        }

        return false;
    }

    private boolean isRowFilled(int row)
    {
        for (Block block : gridArray[row]) 
        {
            if (block == null)
            {
                System.out.println("linia nie jest pusta");
                return false;
            }
        }

        return true;
    }

    private void clearRow(int row)
    {
        Block[] removedRow = new Block[Settings.getColumns()];
        for (Block block : gridArray[row]) 
        {
            removedRow[block.getColumn()] = block;
            gridArray[row][block.getColumn()] = null;
        }

        this.removedRows.add(removedRow);
        this.rowsArragmentChanged += 1;

        for (int currentRow = row - 1; currentRow >= 0; currentRow--) 
        {
            for (Block currentBlock : gridArray[currentRow])
            {
                if (currentBlock == null)
                {
                    continue;  // tutaj cos nie działa
                }

                System.out.println("Przesuwam blok w " + currentBlock.getColumn() + " kolumnie i " + currentBlock.getRow() + " rzędziwe");
                gridArray[currentRow][currentBlock.getColumn()] = null;
                currentBlock.moveDown();
                gridArray[currentBlock.getRow()][currentBlock.getColumn()] = currentBlock;
            }
        }

        gameRender.renderBlocks(removedRow, gridArray);
        score += 200;
    }

    public Figure getActiveFigure()
    {
        return this.activeFigure;
    }

    public Block[][] getGridArray() 
    {
        return this.gridArray;
    }

    public ArrayList<Block[]> getRemovedRow() 
    {
        return removedRows;
    }

    public int getScore()
    {
        return score;
    }

    public int getRowsArragmentChanged() 
    {
        int helpNumberOfRows = this.rowsArragmentChanged;
        this.rowsArragmentChanged = 0;
        return helpNumberOfRows;
    }

    private void endGame()
    {
        Platform.runLater(() -> gameRender.endOfgameAlert(score));
        interrupt();
    }

    public void run()
    {
        while (!interrupted())
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            synchronized(mutex)
            {
                if (checkCollision("down"))
                {
                    ArrayList<Integer> filledRowsNumbers = new ArrayList<Integer>();
                    for (Block block : activeFigure.getBlocks())
                    {
                        gridArray[block.getRow()][block.getColumn()] = block;
                        // System.out.println("zapisuje bloki"); // jak coś to to zmień, bo się pogniewamy

                        if (isRowFilled(block.getRow()))
                        {
                            filledRowsNumbers.add(block.getRow());  // bład zlokalizowany - cel: zneutralizować.
                                                      // błąd zneutralizowany.
                        }
                    }

                    Collections.sort(filledRowsNumbers);
                    for (int rowNumber = 0; rowNumber < filledRowsNumbers.size(); rowNumber++)
                    {
                        clearRow(filledRowsNumbers.get(rowNumber));  // bład zlokalizowany - cel: zneutralizować.
                        try {
                            Thread.sleep(55);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }                       // błąd zneutralizowany.
                    }

                    activeFigure = getRandomFigure();

                    if (checkCollision("down"))
                    {
                        System.out.println("GameOver");
                        endGame();
                    }

                    gameRender.renderFigure(activeFigure);
                    continue;
                }
            }

            synchronized(mutex)
            {
                // System.out.println("figura spada");
                activeFigure.moveDown();
                gameRender.renderFigure(activeFigure);
            }
        }
    }
}
