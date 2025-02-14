package questions;
import java.util.*;

public class MultipleSelect extends OptionQuestion{
    private Set<Integer> correctAnswers;
    private Set<Integer> userAnswers;
    private String result ="Incorrect";
    public MultipleSelect(String text, String correct_ans,String... options) {
        super(text,options);
        this.correctAnswers=parseAnswer(correct_ans);
        for (int ans:correctAnswers){
            if(ans<1 || ans>options.length){
                throw new IllegalArgumentException("Invalid correct answer, must start at 1 and less than" +
                        "options size");
            }
        }
    }
    private Set<Integer> parseAnswer(String answer)
    {
        Set<Integer> answerSet = new HashSet<>();
        String[] parts = answer.trim().split("\\s+");
        try {
            for (String part : parts) {
                int optionNumber = Integer.parseInt(part);
                if (optionNumber < 1 || optionNumber > options.size()) {
                    throw new IllegalArgumentException("Invalid answer: Option number out of range.");
                }
                answerSet.add(optionNumber);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Answer must be numbers separated by spaces.");
        }
        return answerSet;
    }
    @Override
    public String answer (String ans) {
        this.userAnswers = parseAnswer(ans);

        // 检查用户答案是否完全等于正确答案
        if (userAnswers.equals(correctAnswers)) {
            this.result = "Correct";
        } else {
            this.result = "Incorrect";
        }
        return result;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question: ").append(getText()).append("\nOptions:\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append(i + 1).append(". ").append(options.get(i));
            if (correctAnswers.contains(i + 1)) {
                sb.append(" (Correct Answer)");
            }
            sb.append("\n");
        }
        sb.append("Your last answer: ");
        if (userAnswers == null || userAnswers.isEmpty()) {
            sb.append("No answer provided");
        } else {
            sb.append(userAnswers.toString());
        }
        sb.append("\nResult: ").append(result);
        return sb.toString();
    }
}
