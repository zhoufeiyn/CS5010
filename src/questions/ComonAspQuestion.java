package questions;
import java.util.List;

public abstract class ComonAspQuestion implements Question{
    //1.Implement Text of each Question
    //2.Get answer as a String
    //3.give result of answer
    protected String text;

    public ComonAspQuestion(String text){
        this.text=text;
    }


    @Override
    public String getText() {
        return this.text;
    }
    @Override
    public void setText(String text){
        this.text=text;
    }
//
    @Override
    public int compareTo(Question other){
        if(this.getClass()==other.getClass()){
            return this.text.compareTo(other.getText());
        }
        else{
            return Integer.compare(this.getQuestionTypePriority(),((ComonAspQuestion) other).getQuestionTypePriority());
        }
    }
    private int getQuestionTypePriority(){
        if(this instanceof TrueFalse) return 1;
        if(this instanceof MultipleChoice) return 2;
        if(this instanceof MultipleSelect) return 3;
        if(this instanceof Likert) return 4;
        return Integer.MAX_VALUE;
    }


}
