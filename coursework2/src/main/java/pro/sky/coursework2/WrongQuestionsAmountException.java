package pro.sky.coursework2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongQuestionsAmountException extends RuntimeException{
    public WrongQuestionsAmountException(int questionsRequested, int questionsAvailable) {
        super("WrongQuestionsAmount. " + questionsRequested + " questions requested, while only " +
                questionsAvailable + " questions available");
    }
}
