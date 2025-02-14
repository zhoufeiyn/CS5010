package questions;
public interface Question extends Comparable<Question>{

    void setText(String text);
    String getText();
    String answer (String ans);

}
