import java.util.*;

public class GameState {
    private List<FlagData> questions;
    private List<String> currentOption;
    private FlagData currentQuestion;

    public GameState() {
        questions = List.of(new FlagData("/images/europaImg/Austria.png", "Austria"),
                new FlagData("/images/europaImg/Belgia.png", "Belgia"),
                new FlagData("/images/europaImg/Czechy.png", "Czechy"),
                new FlagData("/images/europaImg/Francja.png", "Francja"),
                new FlagData("/images/europaImg/Grecja.png", "Grecja"),
                new FlagData("/images/europaImg/Irlandia.png", "Irlandia"),
                new FlagData("/images/europaImg/Japonia.png", "Japonia"),
                new FlagData("/images/europaImg/Niemcy.png", "Niemcy"),
                new FlagData("/images/europaImg/Turcja.png", "Turcja"),
                new FlagData("/images/europaImg/Ukraina.png", "Ukraina"));
        loadNextQuestion();
    }

    public void loadNextQuestion() {
        Random random = new Random();
        currentQuestion = questions.get(random.nextInt(questions.size()));
        generateOptions();
    }

    private void generateOptions() {
        currentOption = new ArrayList<>();
        currentOption.add(currentQuestion.getCorrectAnswer());

        List<String> others = new ArrayList<>();
        for (FlagData fg : questions) {
            if (!fg.getCorrectAnswer().equals(currentQuestion.getCorrectAnswer())) {
                others.add(fg.getCorrectAnswer());
            }
        }

        Collections.shuffle(others);
        currentOption.addAll(others.subList(0,3));

        Collections.shuffle(currentOption);
    }

    public FlagData getCurrentQuestion() {
        return currentQuestion;
    }

    public List<String> getCurrentOption() {
        return currentOption;
    }

    boolean isCorrectAnswer(String answer) {
        return currentQuestion.getCorrectAnswer().equals(answer);
    }

    public void update() {
        // TODO: aktualizacja stanu gry (ruch, kolizje itp.)
    }
}


