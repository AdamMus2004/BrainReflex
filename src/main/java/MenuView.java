import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MenuView extends Pane {

    private Canvas canvas; // Obszar do rysowania 2D

    public MenuView() {
        // Tworzymy canvas o rozmiarze 800x600
        canvas = new Canvas(1650, 1050);

        // Dodajemy canvas do tej "pustej" ramki (Pane)
        getChildren().add(canvas);
    }
    public void render(GameState state) {
        // Pobieramy obiekt do rysowania na canvasie
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Czyścimy cały ekran czarnym kolorem (tło)
        gc.setFill(Color.RED);
        gc.fillRect(0, 0, 1650, 1050);

    }
}