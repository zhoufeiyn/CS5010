package questions;
import java.util.List;

public class Likert extends ComonAspQuestion{
    private static final List<String> options = List.of("Strongly Agree",
            "Agree", "Neither Agree nor Disagree", "Disagree", "Strongly Disagree");
    private String user_answer=null;
    private String result="Incorrect";
    public Likert(String text) {
        super(text);
    }

    @Override
    public String answer (String ans) {
        String t=this.getText();
        try{
            int index = Integer.parseInt(ans);
            if(index>=1 && index<=5){
                this.user_answer=ans;
                this.result="Correct";
                return result;
            }
            else{
                this.result="Incorrect";
                return result;

            }
        }
        //If index cannot be converted to integer;
        catch(NumberFormatException e){

            this.result="Incorrect";
            return result;
        }
    }

    public List<String> getOption(){
        return options;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question: ").append(getText()).append("\nOptions:\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append(i + 1).append(". ").append(options.get(i)).append("\n");
        }
        sb.append("Your last answer: ").append(user_answer == null ? "No answer provided" : user_answer);
        return sb.toString();
    }

//    public static void main(String[] args) {
//        Likert q1=new Likert("choose12345");
//        String r1=q1.answer("0");
//        System.out.println("q1"+r1);
//        Likert q2=new Likert("choose66666");
//        String r2=q2.answer("6");
//        System.out.println("q2"+r2);
//    }



}
