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
        state.update();
    }
}

