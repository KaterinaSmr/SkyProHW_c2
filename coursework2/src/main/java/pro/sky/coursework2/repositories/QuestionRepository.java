package pro.sky.coursework2.repositories;

import pro.sky.coursework2.models.Question;

import java.util.Collection;
import java.util.Optional;

public interface QuestionRepository {

    void init();

    boolean add(Question question);

    boolean remove(Question question);

    Optional<Question> find (String question);

    Collection<Question> getAll();

}
