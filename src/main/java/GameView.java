import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class GameView extends Pane {

    protected Canvas canvas;



    public GameView() {
        canvas =new Canvas(1650,1050);
        getChildren().add(canvas);

    }

    public void render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double centerX = 1650 / 2;
        double centerY = 1050 / 2;

        gc.setFill(Color.DARKBLUE);
        gc.fillRect(0,0,1650,1050);

        gc.setFill(Color.BLACK);
        gc.fillOval(centerX-600/2,centerY-600/2,600,600);

        gc.setFill(Color.BLUE);
        gc.fillOval(centerX-550/2,centerY-550/2,550,550);

        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,1680,1050);

        gc.setFill(Color.GREEN);
        gc.setFont(new Font("Arial",50));
        gc.fillText("czcionka 1",0,50);

        gc.setFont(new Font("Consolas",50));
        gc.fillText("czcionka 2",0,100);

        gc.setFont(new Font("Verdana",50));
        gc.fillText("czcionka 3",0,150);

        gc.setFont(new Font("Courier New",50));
        gc.fillText("czcionka 4",0,200);

        gc.setFont(new Font("Times New Roman",50));
        gc.fillText("czcionka 5",0,250);


    }
}




