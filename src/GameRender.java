
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class GameRender
{
    private GameDirector gameDirector;
    private GridPane gridPane;
    private Object mutex;

    public GameRender(GridPane gridPane, Object mutex)
    {
        this.gridPane = gridPane;
        this.mutex = mutex;
    }

    public void renderFigure(Figure activeFigure)
    {
        Block[] activeBlocks = activeFigure.getBlocks();
        // System.out.println("Aktualizuje bloczki");
        for (Block activeBlock : activeBlocks) 
        {
            // System.out.println(activeBlock.getColumn());
            Platform.runLater(() -> gridPane.getChildren().remove(activeBlock));

            Platform.runLater(() -> gridPane.add(activeBlock, activeBlock.getColumn(), activeBlock.getRow()));
        }
    }

    public void renderBlocks(Block[] removedRow, Block[][] gridArray)
    {   
        for (Block block : removedRow) 
        {
            Platform.runLater(() -> block.setStroke(Color.RED));

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            Platform.runLater(() -> gridPane.getChildren().remove(block));   
        }

        for (Block[] row : gridArray) 
        {
            for (Block block : row) 
            {   
                if (block == null)
                {
                    continue;
                }

                Platform.runLater(() -> gridPane.getChildren().remove(block));
                Platform.runLater(() -> gridPane.add(block, block.getColumn(), block.getRow()));
            }
        }
    }   

    public void endOfgameAlert(final int score)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("You lost");
        alert.setHeaderText(null);
        alert.setContentText("You lost, your resul: " + score);

        alert.showAndWait();
    }
}

