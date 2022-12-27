package pro.sky.coursework2.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pro.sky.coursework2.models.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
@Qualifier("mathQuestionRepository")
public class MathQuestionRepository implements QuestionRepository{
    private final Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    @Override
    public void init() {
        questions.add(new Question("1 + 3", "3"));
        questions.add(new Question("2 * 2", "4"));
        questions.add(new Question("10 / 1", "10"));
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
