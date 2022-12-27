package pro.sky.coursework2.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.WrongQuestionsAmountException;
import pro.sky.coursework2.models.Question;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock(name="javaQuestionService")
    private QuestionService javaQuestionService;
    @Mock(name="mathQuestionService")
    private QuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    private void setUp(){
        out = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
        Collection<Question> javaQuestions;
        Collection<Question> mathQuestions;

        javaQuestions= new HashSet<>();
        javaQuestions.add(new Question("Назовите принципы ООП", "Наследование, инкапсуляция, полиморфизм, абстракция"));
        javaQuestions.add(new Question("Какой метод используется для проверки на равенство объектов?", "Метод equals()"));
        javaQuestions.add(new Question("Какой интерфейс является главным для всех коллекций?",
                "Интерфейс Collection, который наследует интерфейс Iterable"));
        mathQuestions = new HashSet<>();
        mathQuestions.add(new Question("1 + 3", "3"));
        mathQuestions.add(new Question("2 * 2", "4"));
        mathQuestions.add(new Question("10 / 1", "10"));

        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);
    }

    @Test
    void shouldReturnCollectionOfQuestionsWhenGetQuestionsCalled() {
        assertInstanceOf(Collection.class, out.getQuestions(2));

        int amount = 5;
        assertEquals(amount, out.getQuestions(amount).size());
    }

    @Test
    void shouldThrowExceptionWhenGetQuestionsCalledWithAmountTooBig(){
        assertThrows(WrongQuestionsAmountException.class, ()->out.getQuestions(10));
    }
}