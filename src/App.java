import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application
{
    public static void main(String[] args) throws Exception 
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception 
    {
        GridPane root = new GridPane();

        Scene scene = new Scene(root);

        stage.setTitle("Kurwa Tetris");
        stage.setScene(scene);

        new BoardGrid(root);

        Object mutex = new Object();
        GameDirector gameDirector = new GameDirector(root, mutex);
        gameDirector.setDaemon(true);
        // Thread gameRender = new GameRender(root, mutex, gameDirector);
        // gameRender.setDaemon(true);

        stage.show();
        root.requestFocus();
        // gameRender.start();
        gameDirector.start();
    }
}
