import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameState {
    private final List<FlagData> questions;
    private List<String> currentOption;
    private FlagData currentQuestion;

    public GameState() {
        questions = List.of(
                new FlagData("/images/europaImg/Albania.png", "Albania"),
                new FlagData("/images/europaImg/Andora.png", "Andora"),
                new FlagData("/images/europaImg/Armenia.png", "Armenia"),
                new FlagData("/images/europaImg/Austria.png", "Austria"),
                new FlagData("/images/europaImg/Azerbejdżan.png", "Azerbejdżan"),
                new FlagData("/images/europaImg/Belgia.png", "Belgia"),
                new FlagData("/images/europaImg/Białoruś.png", "Białoruś"),
                new FlagData("/images/europaImg/Bośnia i Hercegowina.png", "Bośnia i Hercegowina"),
                new FlagData("/images/europaImg/Bułgaria.png", "Bułgaria"),
                new FlagData("/images/europaImg/Chorwacja.png", "Chorwacja"),
                new FlagData("/images/europaImg/Czarnogóra.png", "Czarnogóra"),
                new FlagData("/images/europaImg/Czechy.png", "Czechy"),
                new FlagData("/images/europaImg/Dania.png", "Dania"),
                new FlagData("/images/europaImg/Estonia.png", "Estonia"),
                new FlagData("/images/europaImg/Finlandia.png", "Finlandia"),
                new FlagData("/images/europaImg/Francja.png", "Francja"),
                new FlagData("/images/europaImg/Gibraltar.png", "Gibraltar"),
                new FlagData("/images/europaImg/Grecja.png", "Grecja"),
                new FlagData("/images/europaImg/Gruzja.png", "Gruzja"),
                new FlagData("/images/europaImg/Hiszpania.png", "Hiszpania"),
                new FlagData("/images/europaImg/Niderlandy.png", "Holandia"),
                new FlagData("/images/europaImg/Irlandia.png", "Irlandia"),
                new FlagData("/images/europaImg/Islandia.png", "Islandia"),
                new FlagData("/images/europaImg/Jersey.png", "Jersey"),
                new FlagData("/images/europaImg/Liechtenstein.png", "Liechtenstein"),
                new FlagData("/images/europaImg/Litwa.png", "Litwa"),
                new FlagData("/images/europaImg/Luksemburg.png", "Luksemburg"),
                new FlagData("/images/europaImg/Łotwa.png", "Łotwa"),
                new FlagData("/images/europaImg/Macedonia Północna.png", "Macedonia Północna"),
                new FlagData("/images/europaImg/Malta.png", "Malta"),
                new FlagData("/images/europaImg/Mołdawia.png", "Mołdawia"),
                new FlagData("/images/europaImg/Monako.png", "Monako"),
                new FlagData("/images/europaImg/Niemcy.png", "Niemcy"),
                new FlagData("/images/europaImg/Norwegia.png", "Norwegia"),
                new FlagData("/images/europaImg/Polska.png", "Polska"),
                new FlagData("/images/europaImg/Portugalia.png", "Portugalia"),
                new FlagData("/images/europaImg/Rosja.png", "Rosja"),
                new FlagData("/images/europaImg/Rumunia.png", "Rumunia"),
                new FlagData("/images/europaImg/San Marino.png", "San Marino"),
                new FlagData("/images/europaImg/Serbia.png", "Serbia"),
                new FlagData("/images/europaImg/Słowacja.png", "Słowacja"),
                new FlagData("/images/europaImg/Słowenia.png", "Słowenia"),
                new FlagData("/images/europaImg/Szwajcaria.png", "Szwajcaria"),
                new FlagData("/images/europaImg/Szwecja.png", "Szwecja"),
                new FlagData("/images/europaImg/Ukraina.png", "Ukraina"),
                new FlagData("/images/europaImg/Watykan.png", "Watykan"),
                new FlagData("/images/europaImg/Węgry.png", "Węgry"),
                new FlagData("/images/europaImg/Wielka Brytania.png", "Wielka Brytania"),
                new FlagData("/images/europaImg/Włochy.png", "Włochy"),
                new FlagData("/images/europaImg/Wyspa Man.png", "Wyspa Man"),
                new FlagData("/images/europaImg/Wyspy Alandzkie.png", "Wyspy Alandzkie"),
                new FlagData("/images/europaImg/Wyspy Owcze.png", "Wyspy Owcze"),
                new FlagData("/images/europaImg/Guernsey.png", "Guernsey"),
                new FlagData("/images/europaImg/Svalbard i Jan Mayen.png", "Svalbard i Jan Mayen")

        );
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
        currentOption.addAll(others.subList(0, 3));
        Collections.shuffle(currentOption);
    }

    public FlagData getCurrentQuestion() {
        return currentQuestion;
    }

    public List<String> getCurrentOption() {
        return currentOption;
    }

    public boolean isCorrectAnswer(String answer) {
        return currentQuestion.getCorrectAnswer().equals(answer);
    }
}
