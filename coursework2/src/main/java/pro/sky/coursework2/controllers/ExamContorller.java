package pro.sky.coursework2.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.coursework2.models.Question;
import pro.sky.coursework2.services.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamContorller {

    private final ExaminerService examinerService;

    public ExamContorller(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable ("amount") Integer amount){
        return examinerService.getQuestions(amount);
    }
}
