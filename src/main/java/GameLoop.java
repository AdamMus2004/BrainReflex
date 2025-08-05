import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
    private final GameState state;
    private final GameView view;
    public int score = 0;

    public GameLoop(GameState state, GameView view) {
        this.state = state;
        this.view = view;
    }

    @Override
    public void handle(long now) {
        view.render();
    }
}
