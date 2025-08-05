import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.List;

public class GameView extends Pane {
    private final GameState gameState;
    private final Canvas canvas;
    private final double centerX = 1650 / 2.0;
    private final double centerY = 1050 / 2.0;
    private final Font arial = new Font("Arial", 25);

    public GameView(GameState state) {
        this.gameState = state;
        canvas = new Canvas(1650, 1050);
        getChildren().add(canvas);
        updateButtons();

    }

    private Button createButton(String text, double x, double y) {
        Button button = new Button(text);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setFont(arial);
        button.setPrefSize(300, 100);
        button.setStyle("-fx-background-color: lightblue; -fx-text-fill: black;");

        button.setOnAction(e -> {
            boolean correct = gameState.isCorrectAnswer(button.getText());
            button.setStyle(correct ?
                    "-fx-background-color: green; -fx-text-fill: white;" :
                    "-fx-background-color: red; -fx-text-fill: white;"
            );

            gameState.loadNextQuestion();
            updateButtons();
            render();
        });

        getChildren().add(button);
        return button;
    }

    public void updateButtons() {
        getChildren().removeIf(node -> node instanceof Button);
        List<String> options = gameState.getCurrentOption();
        for (int i = 0; i < options.size(); i++) {
            String text = options.get(i);
            double x = centerX / 2 * (i + 0.5) - 150;
            double y = centerY + 200;
            createButton(text, x, y);
        }
    }

    public void render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.ANTIQUEWHITE);
        gc.fillRect(0, 0, 1650, 1050);

        String imgUrl = gameState.getCurrentQuestion().getImgPath();
        Image img = new Image(getClass().getResource(imgUrl).toExternalForm());
        gc.drawImage(img, centerX - img.getWidth() / 2, 50);

    }
}
