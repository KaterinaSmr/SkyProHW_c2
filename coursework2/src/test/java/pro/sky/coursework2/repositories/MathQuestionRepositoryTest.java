package pro.sky.coursework2.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2.models.Question;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {
    private QuestionRepository out;

    @BeforeEach
    private void setUp(){
        out = new MathQuestionRepository();
    }

    @Test
    void add() {
        Question question = new Question("Вопрос", "Ответ");
        assertTrue(out.add(question));
    }

    @Test
    void remove() {
        Question question = new Question("Вопрос", "Ответ");
        out.add(question);
        assertTrue(out.remove(question));
    }

    @Test
    void find() {
        Question question = new Question("Вопрос", "Ответ");
        out.add(question);
        assertEquals(Optional.of(question), out.find("Вопрос"));
    }

    @Test
    void getAll() {
        assertInstanceOf(Collection.class, out.getAll());
    }
}