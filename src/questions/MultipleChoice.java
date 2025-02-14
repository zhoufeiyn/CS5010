package questions;
import java.util.List;

public class MultipleChoice extends OptionQuestion{
    private String correct_ans;
    private String user_answer=null;
    private String result="Incorrect";
    public MultipleChoice(String text,String correct_ans, String... options) {
        super(text,options);
        int ca= Integer.parseInt(correct_ans);
        if(ca>=1 && ca<=options.length)
        {this.correct_ans=correct_ans;}
        else{
            throw new IllegalArgumentException("Invalid correct answer");
        }
    }


    @Override
    public String answer (String ans) {
        String t=this.getText();
        try{
            int index = Integer.parseInt(ans);
            if (index>options.size() ||index<1){

                this.result="Incorrect";
                return result;
            }
            if(index==Integer.parseInt(correct_ans)){
                this.user_answer=ans;
                this.result="Correct";
                return result;
            }
            else{
                this.user_answer=ans;
                this.result="Incorrect";
                return result;

            }
        }
        catch (NumberFormatException e){
            this.result="Incorrect";
            return result;

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question: ").append(getText()).append("\nOptions:\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append(i + 1).append(". ").append(options.get(i));
            if (i + 1 == Integer.parseInt(correct_ans)) {
                sb.append(" (Correct Answer)");
            }
            sb.append("\n");
        }
        sb.append("Your last answer: ").append(user_answer == null ? "No answer provided" : user_answer);
        sb.append("\nResult: ").append(user_answer == null ? "No result" : result);
        return sb.toString();
    }

//    public static void main(String[] args) {
//        MultipleChoice question1 =new MultipleChoice("Which letter is A?","1","A","B","C","D");
//        String res1=question1.answer("1");
//        System.out.println(res1);
//
//        MultipleChoice question2 =new MultipleChoice("Which one of these options accurately describes your experience in Assignment 2?","2","1","2","3");
//        String res2=question2.answer("1");
//        System.out.println(res2);
//    }

}