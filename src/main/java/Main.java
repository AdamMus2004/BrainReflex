import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        GameState state = new GameState();
        GameView view = new GameView(state);
        GameLoop loop = new GameLoop(state,view);

        Scene scene = new Scene(view,1650,1050);

        primaryStage.setTitle("brainReflex");
        primaryStage.setScene(scene);
        primaryStage.show();

        loop.start();

    }

    public static void main(String[] args) {
        launch();
    }
}

