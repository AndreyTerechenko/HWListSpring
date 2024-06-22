package exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExeptionNotFound extends RuntimeException {
    @Override
    public String toString() {
        return "Ошибка!!! Сотрудник не найден!";
    }
}
