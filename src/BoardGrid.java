
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardGrid 
{
    private final GridPane gridPane;

    public BoardGrid(GridPane gridPane)
    {
        this.gridPane = gridPane;
        createBoard();
    }

    private void createBoard()
    {
        for (int column = 0; column < Settings.getColumns(); column++)
        {
            for (int row = 0; row < Settings.getRows(); row++)
            {
                Square cell = new Square();
                gridPane.add(cell, column, row);
            }
        }

        // Figure figure = new TFigure();
        // for (Block block : figure.getBlocks()) 
        // {
        //     gridPane.add(block, block.getColumn(), block.getRow());
        // }
    }
}
