package questions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MultipleChoiceTest {
    private MultipleChoice question;
    @Before
    public void setup(){

        question =new MultipleChoice("Which letter is A?","1","A","B","C","D");
    }
    //evaluate the correct answer
    @Test(expected = IllegalArgumentException.class)
    public void testGiveInvalidCorrectAnswer1(){
        new MultipleChoice("Which letter is A?","0","A","B","C","D");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGiveInvalidCorrectAnswer2(){
        new MultipleChoice("Which letter is A?","9","A","B","C","D");
    }
    //evaluate answer
    @Test
    public void testEvaluateCorrectAnswer(){
        assertEquals("Correct",question.answer ("1"));
    }
    @Test
    public void testEvaluateInCorrectAnswer(){
        assertEquals("Incorrect",question.answer ("2"));
    }
    @Test
    public void testEvaluateInvalidNotNumberAnswer(){
        assertEquals("Incorrect",question.answer (null));
    }
    @Test
    public void testEvaluateInvalidNumberAnswer1(){
        assertEquals("Incorrect",question.answer ("-1"));
    }
    @Test
    public void testEvaluateInvalidNumberAnswer2(){
        assertEquals("Incorrect",question.answer ("5"));
    }
//Test options
    @Test
    public void testGetOptions(){
        assertEquals(Arrays.asList("A","B","C","D"),question.getOptions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOptionsLess3(){
//        List<String> options2= Arrays.asList("A","B");
        new MultipleChoice("Which letter is A?","1","A","B");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testOptionOver8(){
//        List<String> options2= Arrays.asList("A","B","C","D","E","F","G","H","I");
        new MultipleChoice("Which letter is A?","1","A","B","C","D","E","F","G","H","I");
    }
//ToString
@Test
    public void testToString() {
        question.answer ("1"); // To ensure the user answer and result are set
        String expected = "Question: Which letter is A?\n" +
                "Options:\n" +
                "1. A (Correct Answer)\n" +
                "2. B\n" +
                "3. C\n" +
                "4. D\n" +
                "Your last answer: 1\n" +
                "Result: Correct";
        assertEquals(expected, question.toString().trim());
    }
}
