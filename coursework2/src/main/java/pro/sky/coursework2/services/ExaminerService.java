package pro.sky.coursework2.services;

import pro.sky.coursework2.models.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
