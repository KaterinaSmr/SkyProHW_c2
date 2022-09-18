package pro.sky.skyprospringhw8;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class EmployeeStorageIsFullException extends RuntimeException{

    public EmployeeStorageIsFullException() {
        super("Массив сотрудников заполнен");
    }
}
