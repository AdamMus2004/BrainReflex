public class FlagData {
    private final String imgPath;
    private final String correctAnswer;

    public FlagData(String imgPath, String correctAnswer) {
        this.imgPath = imgPath;
        this.correctAnswer = correctAnswer;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
