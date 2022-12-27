package pro.sky.coursework2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.WrongQuestionsAmountException;
import pro.sky.coursework2.models.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                                @Qualifier("mathQuestionService") QuestionService mathQuestionServcie) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionServcie;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> allQuestions = new HashSet<>();
        allQuestions.addAll(javaQuestionService.getAll());
        allQuestions.addAll(mathQuestionService.getAll());
        int size = allQuestions.size();
        if (size < amount || amount < 0){
            throw new WrongQuestionsAmountException(amount, size);
        }

        Random random = new Random();
        Question[] allQuestionsArray = allQuestions.toArray(new Question[0]);

        Set<Question> result = new HashSet<>();
        while (result.size() < amount){
            int randomIndex = random.nextInt(size);
            result.add(allQuestionsArray[randomIndex]);
        }
        return result;
    }
}
