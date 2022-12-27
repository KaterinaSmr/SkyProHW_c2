package pro.sky.coursework2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.QuestionNotFoundException;
import pro.sky.coursework2.models.Question;
import pro.sky.coursework2.repositories.QuestionRepository;

import java.util.*;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return getQuestionWithAnswer(question.getQuestion()).orElse(question);
    }

    @Override
    public Question remove(Question question) {
        questionRepository.remove(question);
        return question;
    }

    public Question remove(String question, String answer) {
        Question questionToRemove = getQuestionWithAnswer(question).orElseThrow(QuestionNotFoundException::new);
        return remove(questionToRemove);
    }

    public Optional<Question> getQuestionWithAnswer(String question){
        return questionRepository.find(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        Collection<Question> questions = getAll();
        int questionIndex = random.nextInt(questions.size());
        return (Question) questions.toArray()[questionIndex];
    }
}
