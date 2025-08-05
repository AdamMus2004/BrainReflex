import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Random;

public class GameView extends Pane {
    private GameState gameState;
    protected Canvas canvas;
    double centerX = 1650 / 2;
    double centerY = 1050 / 2;
    Font arial = new Font("Arial",50);

    private Button createButton(String text, double x, double y, Runnable action) {
        Button button = new Button(text);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setFont(arial);
        button.setPrefHeight(100);
        button.setPrefWidth(300);
        button.setStyle("-fx-background-color: lightblue; -fx-text-fill: black;");

        button.setOnAction(e -> {
            boolean correct = gameState.isCorrectAnswer(button.getText());
            if (correct) {
                button.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                System.out.println("Dobra odpowiedź!");
            } else {
                button.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                System.out.println("Zła odpowiedź :(");
            }
        });

        getChildren().add(button);
        return button;
    }

    public void updateButtons() {
        getChildren().removeIf(node -> node instanceof Button);
        List<String> options = gameState.getCurrentOption();
        for (int i = 0; i < options.size(); i++) {
            String text = options.get(i);
            double x = centerX/2*((double) i+0.5)-150;
            double y = centerY + 200;
            createButton(text,x,y,null);
        }
    }
    public GameView(GameState state) {
        this.gameState = state;
        canvas =new Canvas(1650,1050);
        getChildren().add(canvas);
        updateButtons();

    }

    public void render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.ANTIQUEWHITE);
        gc.fillRect(0,0,1680,1050);
        String imgUrl = gameState.getCurrentQuestion().getImgPath();
        Image img = new Image(getClass().getResource(imgUrl).toExternalForm());
        gc.drawImage(img,centerX-img.getWidth()/2,50);
        gc.setFont(arial);
        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText("Jaka to flaga",centerX,centerY);

    }
}




