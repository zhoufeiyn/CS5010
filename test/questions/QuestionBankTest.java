package questions;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class QuestionBankTest {
    private QuestionBank questionBank;

    @Before
    public void setUp() {
        questionBank = new QuestionBank();
        // 添加不同类型的问题，确保它们按照正确的顺序排序
        questionBank.addQuestion(new Likert("How satisfied are you with our service?"));
        questionBank.addQuestion(new MultipleChoice("What is the capital of France?", "2", "Berlin", "Paris", "Madrid"));
        questionBank.addQuestion(new MultipleSelect("Choose prime numbers", "1 2", "2", "3", "4", "5"));
        questionBank.addQuestion(new TrueFalse("The earth is flat.", "False"));
    }

    @Test
    public void testQuestionsSortedCorrectly() {
        List<Question> questions = questionBank.getQuestions();
        // 确保问题按照特定的类型顺序排列
        assertTrue(questions.get(0) instanceof TrueFalse);
        assertTrue(questions.get(1) instanceof MultipleChoice);
        assertTrue(questions.get(2) instanceof MultipleSelect);
        assertTrue(questions.get(3) instanceof Likert);

        // 可选：检查问题文本是否按照字典顺序排列（如果有相同类型的多个问题）
    }

    @Test
    public void testAddingQuestionsMaintainsOrder() {
        // 添加一个新问题，检查顺序是否仍然正确
        questionBank.addQuestion(new TrueFalse("Is Java a programming language?", "True"));
        List<Question> questions = questionBank.getQuestions();

        // 检查添加的问题是否在预期的位置
        assertTrue(questions.get(0) instanceof TrueFalse);
        assertTrue(questions.get(1) instanceof TrueFalse);
        assertTrue(questions.get(2) instanceof MultipleChoice);
    }
}
