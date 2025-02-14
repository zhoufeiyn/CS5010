package questions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MultipleSelectTest {
    private MultipleSelect question;

    @Before
    public void setup() {
        question = new MultipleSelect("Select prime numbers between 1 and 4:", "2 3", "1", "2", "3", "4");
    }

    //Correct Answer
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCorrectAnswerOutOfRange() {
        // > option size
        new MultipleSelect("Select prime numbers:", "2 5", "1", "2", "3", "4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCorrectAnswerZero() {
        // not <1
        new MultipleSelect("Select prime numbers:", "0 2", "1", "2", "3", "4");
    }

    // Answer
    @Test
    public void testEvaluateCorrectAnswer() {
        assertEquals("Correct", question.answer ("2 3"));
    }

    @Test
    public void testEvaluateCorrectAnswerOutOfOrder() {
        // any order is ok
        assertEquals("Correct", question.answer ("3 2"));
    }

    // incorrect answer
    @Test
    public void testEvaluateIncompleteAnswer() {
        // select only one option in correct answer Incorrect
        assertEquals("Incorrect", question.answer ("2"));
    }

    @Test
    public void testEvaluateExtraIncorrectAnswer() {
        // select correct answer+ other option（例如 4）
        assertEquals("Incorrect", question.answer ("2 3 4"));
    }
    @Test
    public void testEvaluateIncorrectAnswer() {
        // select incorrect answer
        assertEquals("Incorrect", question.answer ("1 4"));
    }

    // answer not number
    @Test(expected = IllegalArgumentException.class)
    public void testEvaluateInvalidAnswerNotNumber() {
        question.answer ("A B");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEvaluateInvalidAnswerOutOfRange() {
        question.answer ("2 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEvaluateInvalidAnswerNegativeNumber() {
        question.answer ("-1 3");
    }

    // options
    @Test
    public void testGetOptions() {
        assertEquals(Arrays.asList("1", "2", "3", "4"), question.getOptions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOptionsLessThanThree() {
        new MultipleSelect("Select prime numbers:", "1 2", "1", "2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOptionsMoreThanEight() {
        new MultipleSelect("Select prime numbers:", "1 2", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    // test：toString
    @Test
    public void testToString() {
        question.answer ("2 3");
        String expected = "Question: Select prime numbers between 1 and 4:\n" +
                "Options:\n" +
                "1. 1\n" +
                "2. 2 (Correct Answer)\n" +
                "3. 3 (Correct Answer)\n" +
                "4. 4\n" +
                "Your last answer: [2, 3]\n" +
                "Result: Correct";
        assertEquals(expected.trim(), question.toString().trim());
    }
}
