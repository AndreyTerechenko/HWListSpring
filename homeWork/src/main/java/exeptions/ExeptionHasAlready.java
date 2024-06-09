package exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExeptionHasAlready extends RuntimeException {
    @Override
    public String toString() {
        return "Ошибка!!! Такой сотрудник уже есть!";
    }
}





