import java.util.List;

public class FlagData {
    private String imgPath;
    private String correctAnswer;
    private List<String> options;

    public FlagData(String imgPath, String correctAnswer) {
        this.imgPath = imgPath;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getCurrentOptions() {
        return options;
    }
}
