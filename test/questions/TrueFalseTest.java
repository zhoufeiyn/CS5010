package questions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TrueFalseTest {
    private TrueFalse question;

    @Before
    public void setup() {
        question = new TrueFalse("Choose True.", "True");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidcorrectAnswer() {
        new TrueFalse("Choose True.", "?"); // 输入为 null
    }
    @Test
    public void testEvaluateCorrectAnswer() {
        assertEquals("Correct", question.answer ("True"));
    }



    @Test
    public void testEvaluateIncorrectAnswer() {
        assertEquals("Incorrect", question.answer ("False"));
    }


    @Test
    public void testEvaluateInvalidAnswer1() {
        assertEquals("Incorrect",question.answer ("Yes"));
    }


    @Test
    public void testEvaluateNullAnswer() {
        assertEquals("Incorrect",question.answer (null));  // 输入为 null
    }


    @Test
    public void testGetOptions() {
        assertEquals(Arrays.asList("True", "False"), question.getOptions());
    }


    @Test
    public void testToString() {
        question.answer ("True");
        String expected = "Question: Choose True.\n" +
                "Options: [True, False]\n" +
                "Your last answer: True\n" +
                "Result: Correct";
        assertEquals(expected.trim(), question.toString().trim());
    }

}
