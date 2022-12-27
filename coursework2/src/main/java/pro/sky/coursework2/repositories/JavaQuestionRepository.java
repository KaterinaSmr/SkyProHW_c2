package pro.sky.coursework2.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pro.sky.coursework2.models.Question;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
@Qualifier("javaQuestionRepository")
public class JavaQuestionRepository implements QuestionRepository{
    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    @Override
    public void init() {
        questions.add(new Question("Назовите принципы ООП", "Наследование, инкапсуляция, полиморфизм, абстракция"));
        questions.add(new Question("Какой метод используется для проверки на равенство объектов?", "Метод equals()"));
        questions.add(new Question("Какой интерфейс является главным для всех коллекций?",
                "Интерфейс Collection, который наследует интерфейс Iterable"));
    }

    @Override
    public boolean add(Question question) {
        return questions.add(question);
    }

    @Override
    public boolean remove(Question question) {
        return questions.remove(question);
    }

    public Optional<Question> find(String question){
        return questions.stream().filter(q -> q.getQuestion().equals(question)).findAny();
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

}
