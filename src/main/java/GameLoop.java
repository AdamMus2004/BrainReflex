import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    private GameState state;
    private GameView view;

    public GameLoop(GameState state, GameView view) {
        this.state = state;
        this.view = view;
    }

    @Override
    public void handle(long now) {
        view.render();
    }
}
//import javafx.animation.AnimationTimer;
//
//// Klasa odpowiedzialna za "pętlę gry" (co 1/60 sekundy)
//public class GameLoop extends AnimationTimer {
//
//    private final GameState state; // Stan gry (pozycje, prędkości)
//    private final GameView view;   // Widok do rysowania
//
//    // Konstruktor dostaje stan gry i widok, które będzie aktualizował
//    public GameLoop(GameState state, GameView view) {
//        this.state = state;
//        this.view = view;
//    }
//
//    // Ta metoda wywoływana jest ~60 razy na sekundę (animacja)
//    @Override
//    public void handle(long now) {
//        state.update();      // Aktualizujemy logikę (np. ruch piłki)
//        view.render(state);  // Rysujemy aktualny stan gry na ekran
//    }
//}
