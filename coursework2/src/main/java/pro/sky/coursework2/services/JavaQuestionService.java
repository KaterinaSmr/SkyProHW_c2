package pro.sky.coursework2.services;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.QuestionNotFoundException;
import pro.sky.coursework2.models.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        questions.add(new Question("Назовите принципы ООП", "Наследование, инкапсуляция, полиморфизм, абстракция"));
        questions.add(new Question("Какой метод используется для проверки на равенство объектов?", "Метод equals()"));
        questions.add(new Question("Какой интерфейс является главным для всех коллекций?",
                "Интерфейс Collection, который наследует интерфейс Iterable"));
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return getQuestionWithAnswer(question.getQuestion()).orElse(question);
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    public Question remove(String question) {
        Question questionToRemove = getQuestionWithAnswer(question).orElseThrow(QuestionNotFoundException::new);
        questions.remove(questionToRemove);
        return questionToRemove;
    }

    public Optional<Question> getQuestionWithAnswer(String question){
        return questions.stream().filter(q -> q.getQuestion().equals(question)).findAny();
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int questionIndex = random.nextInt(questions.size());
        return (Question) questions.toArray()[questionIndex];
    }
}
