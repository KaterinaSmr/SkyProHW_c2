package pro.sky.coursework2.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.QuestionNotFoundException;
import pro.sky.coursework2.models.Question;
import pro.sky.coursework2.repositories.MathQuestionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mathQuestionRepository;
    @InjectMocks
    private MathQuestionService out;

    Set<Question> questions;

    @BeforeEach
    private void setUp(){
        questions = new HashSet<>();
        questions.add(new Question("1 + 3", "3"));
        questions.add(new Question("2 * 2", "4"));
        questions.add(new Question("10 / 1", "10"));
    }

    @Test
    void shouldReturnQuestionWhenAddCalledWithQuestionObject() {
        Question question = new Question("5 - 5", "0");
        when(mathQuestionRepository.add(any(Question.class))).thenReturn(questions.add(question));
        assertEquals(question, out.add(question));
    }

    @Test
    void shouldReturnQuestionWhenAddCalledWithQuestionAndAnswerStrings() {
        Question question = new Question("5 - 5", "0");
        when(mathQuestionRepository.find(anyString()))
                .thenReturn(Optional.of(question));
        when(mathQuestionRepository.add(any(Question.class))).thenReturn(questions.add(question));
        assertEquals(question, out.add("5 - 5", "0"));
    }

    @Test
    void shouldReturnQuestionWhenRemoveCalledWithQuestion() {
        Question question = new Question("5 - 5", "0");
        questions.add(question);
        when(mathQuestionRepository.remove(question)).thenReturn(questions.remove(question));
        assertEquals(question, out.remove(question));
    }

    @Test
    void shouldReturnQuestionWhenRemoveCalledWithQuestionAndAnswerStrings() {
        Question question = new Question("5 - 5", "0");
        questions.add(question);
        when(mathQuestionRepository.find(anyString()))
                .thenReturn(Optional.of(question));
        when(mathQuestionRepository.remove(question)).thenReturn(questions.remove(question));
        assertEquals(question, out.remove("5 - 5", ""));
    }

    @Test
    void shouldThrowExceptionWhenRemoveCalledWithInvalidQuestion() {
        Question question = new Question("Test", "Test");
        when(mathQuestionRepository.remove(question))
                .thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(question));
    }

    @Test
    void shouldReturnCollectionOfQuestionsWhenGetAllCalled() {
        when(mathQuestionRepository.getAll()).thenReturn(questions);
        assertInstanceOf(Collection.class, out.getAll());
    }

    @Test
    void shouldReturnQuestionWhenGetRandomQuestionCalled() {
        when(mathQuestionRepository.getAll()).thenReturn(questions);
        assertInstanceOf(Question.class, out.getRandomQuestion());
    }
}