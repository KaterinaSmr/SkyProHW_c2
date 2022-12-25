package pro.sky.coursework2.services;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.WrongQuestionsAmountException;
import pro.sky.coursework2.models.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if (size < amount){
            throw new WrongQuestionsAmountException(amount, size);
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount){
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
