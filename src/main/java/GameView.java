import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import java.util.Random;

public class GameView extends Pane {

    protected Canvas canvas;
    double centerX = 1650 / 2;
    double centerY = 1050 / 2;
    Font arial = new Font("Arial",50);

    private Button createButton(String text, double x, double y, Runnable action) {
        Button button = new Button(text);
        button.setLayoutX(x);
        button.setLayoutY(y);
        getChildren().add(button);
        button.setFont(arial);
        button.setPrefHeight(100);
        button.setPrefWidth(300);
        button.setOnAction(e -> action.run());
        button.setStyle("-fx-background-color: lightblue; -fx-text-fill: black;");
        return button;
    }

    public GameView() {
        canvas =new Canvas(1650,1050);
        getChildren().add(canvas);

        Button btn1 = createButton("Antartyda",centerX/2-300-56.25,centerY+200,null);
        btn1.setOnAction(e -> btn1.setStyle("-fx-background-color: green; -fx-text-fill: darkblue;"));
        Button btn2 = createButton("Europa",centerX-300-56.25,centerY+200,()->{
            System.out.println("siema");
        });
        Button btn3 = createButton("Azja",centerX+(centerX/2)-300-56.25,centerY+200,()->{
            System.out.println("siema");});
        Button btn4 = createButton("Australia",centerX+centerX-300-56.25,centerY+200,()->{
            System.out.println("siema");});


    }

    public void render() {
        String[] imagesArr = {
                "/images/europaImg/Austria.png",
                "/images/europaImg/Belgia.png",
                "/images/europaImg/Czechy.png",
                "/images/europaImg/Francja.png",
                "/images/europaImg/Grecja.png",
                "/images/europaImg/Irlandia.png",
                "/images/europaImg/Japonia.png",
                "/images/europaImg/Niemcy.png",
                "/images/europaImg/Turcja.png",
                "/images/europaImg/Ukraina.png",
        };
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,1680,1050);

        Random rand = new Random();
        String randomImg = imagesArr[rand.nextInt(imagesArr.length)];
        Image img = new Image(getClass().getResource(randomImg).toExternalForm());
        gc.drawImage(img,centerX-img.getWidth()/2,50);



    }
}




