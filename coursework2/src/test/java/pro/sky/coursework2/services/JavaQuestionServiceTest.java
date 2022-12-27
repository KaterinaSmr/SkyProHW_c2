package pro.sky.coursework2.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.QuestionNotFoundException;
import pro.sky.coursework2.models.Question;
import pro.sky.coursework2.repositories.JavaQuestionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;
    @InjectMocks
    private JavaQuestionService out;

    Set<Question> questions;

    @BeforeEach
    private void setUp(){
        questions= new HashSet<>();
        questions.add(new Question("Назовите принципы ООП", "Наследование, инкапсуляция, полиморфизм, абстракция"));
        questions.add(new Question("Какой метод используется для проверки на равенство объектов?", "Метод equals()"));
        questions.add(new Question("Какой интерфейс является главным для всех коллекций?",
                "Интерфейс Collection, который наследует интерфейс Iterable"));
    }

    @Test
    void shouldReturnQuestionWhenAddCalledWithQuestionObject() {
        Question question = new Question("Вопрос", "Ответ");
        when(javaQuestionRepositoryMock.add(any(Question.class))).thenReturn(questions.add(question));
        assertEquals(question, out.add(question));
    }

    @Test
    void shouldReturnQuestionWhenAddCalledWithQuestionAndAnswerStrings() {
        Question question = new Question("Вопрос", "Ответ");
        when(javaQuestionRepositoryMock.find(anyString()))
                .thenReturn(Optional.of(question));
        when(javaQuestionRepositoryMock.add(any(Question.class))).thenReturn(questions.add(question));
        assertEquals(question, out.add("Вопрос", "Ответ"));
    }

    @Test
    void shouldReturnQuestionWhenRemoveCalledWithQuestion() {
        Question question = new Question("Вопрос", "Ответ");
        questions.add(question);
        when(javaQuestionRepositoryMock.remove(question)).thenReturn(questions.remove(question));
        assertEquals(question, out.remove(question));
    }

    @Test
    void shouldReturnQuestionWhenRemoveCalledWithQuestionAndAnswerStrings() {
        Question question = new Question("Вопрос", "Ответ");
        questions.add(question);
        when(javaQuestionRepositoryMock.find(anyString()))
                .thenReturn(Optional.of(question));
        when(javaQuestionRepositoryMock.remove(question)).thenReturn(questions.remove(question));
        assertEquals(question, out.remove("Вопрос", ""));
    }

    @Test
    void shouldThrowExceptionWhenRemoveCalledWithInvalidQuestion() {
        Question question = new Question("Test", "Test");
        when(javaQuestionRepositoryMock.remove(question))
                .thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(question));
    }

    @Test
    void shouldReturnCollectionOfQuestionsWhenGetAllCalled() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(questions);
        assertInstanceOf(Collection.class, out.getAll());
    }

    @Test
    void shouldReturnQuestionWhenGetRandomQuestionCalled() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(questions);
        assertInstanceOf(Question.class, out.getRandomQuestion());
    }
}