package questions;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class LikertTest {
    private Likert question;

    @Before
    public void setUp() {
        question = new Likert("Do you agree with this statement?");
    }
//Text
    @Test
    public void testGetText(){
        assertEquals("Do you agree with this statement?",question.getText());
    }
    @Test
    public void testSetText(){
        question.setText("Do you agree?");
        assertEquals("Do you agree?",question.getText());
    }

    //Options
    @Test
    public void testGetOption(){
        assertEquals(List.of("Strongly Agree",
                "Agree", "Neither Agree nor Disagree", "Disagree", "Strongly Disagree"),question.getOption());
    }

    //evaluate answer
    @Test
    public void testEvaluateCorrectAnswer() {
        for (int i = 1; i <= 5; i++) {
            assertEquals("Correct", question.answer (Integer.toString(i)));
        }
    }

    @Test
    public void testEvaluateInvalidAnswer() {
        assertEquals("Incorrect",question.answer ("?"));
    }

    @Test
    public void testEvaluateAnsweNotinSize1() {
        assertEquals("Incorrect",question.answer ("0"));
    }
    @Test
    public void testEvaluateAnsweNotinSize2() {
        assertEquals("Incorrect",question.answer ("6"));
    }
    //toString
    @Test
    public void testToString() {
        question.answer ("3"); // setting a user answer
        String expectedOutput = "Question: Do you agree with this statement?\nOptions:\n" +
                "1. Strongly Agree\n" +
                "2. Agree\n" +
                "3. Neither Agree nor Disagree\n" +
                "4. Disagree\n" +
                "5. Strongly Disagree\n" +
                "Your last answer: 3";
        assertEquals(expectedOutput, question.toString().trim());
    }


}