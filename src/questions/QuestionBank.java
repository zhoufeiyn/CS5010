package questions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> questions;
    public QuestionBank(){
        this.questions=new ArrayList<>();
    }
    public void addQuestion(Question question){
        questions.add(question);
        Collections.sort(questions);
    }
    public List<Question> getQuestions() {
        return questions;
    }

}
