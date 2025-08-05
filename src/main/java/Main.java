import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    double x = 100;
    double y = 100;
    double vx = 3;
    double vy = 2;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Scene scene = new Scene(new javafx.scene.Group(canvas));
        stage.setScene(scene);
        stage.setTitle("JavaFX Game Loop");
        stage.show();

        // Game loop
        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                update();
                render(gc);
            }
        };
        timer.start();
    }

    void update() {
        x += vx;
        y += vy;

        if (x <= 0 || x >= 800 - 30) vx *= -1;
        if (y <= 0 || y >= 600 - 30) vy *= -1;
    }

    void render(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 800, 600);

        gc.setFill(Color.RED);
        gc.fillOval(x, y, 30, 30);
    }

    public static void main(String[] args) {
        launch();
    }
}
