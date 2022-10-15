package pro.sky.skyprocourse2hw13;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeWrongDataException extends RuntimeException{
    public EmployeeWrongDataException() {
        super("Некорректные символы в данных сотрудника");
    }
}
