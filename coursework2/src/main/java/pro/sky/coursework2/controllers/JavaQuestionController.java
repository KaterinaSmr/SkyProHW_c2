package pro.sky.coursework2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.models.Question;
import pro.sky.coursework2.services.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping
    public Collection<Question> getAllQuestions(){
        return javaQuestionService.getAll();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam ("question") String question,
                                @RequestParam ("answer") String answer){
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam ("question") String question) {
        return javaQuestionService.remove(question);
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestParam ("question") String question){
        return javaQuestionService.getQuestionWithAnswer(question).orElse(null);
    }
}
