package questions;
import java.util.Arrays;
import java.util.List;

public class TrueFalse extends ComonAspQuestion{
    private String correctAnswer;
    private String userAnswer;
    private String result ="Incorrect";
    private static final List<String> options=Arrays.asList("True","False");
    public TrueFalse(String text,String correctAnswer) {
        super(text);
        if (!options.contains(correctAnswer)) {
            throw new IllegalArgumentException("Answer must be 'True' or 'False'.");
        }
        this.correctAnswer=correctAnswer;
    }

    @Override
    public String answer (String ans) {
         if (!options.contains(ans)) {
            return result;
        }
        userAnswer = ans;
        if (userAnswer.equalsIgnoreCase(correctAnswer) ) {
            result = "Correct";
        } else {
            result = "Incorrect";
        }
        return result;
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question: ").append(getText()).append("\n");
        sb.append("Options: ").append(getOptions()).append("\n");
        sb.append("Your last answer: ").append(userAnswer == null ? "No answer provided" : userAnswer);
        sb.append("\nResult: ").append(result);
        return sb.toString();
    }
}
