package thanhtrong.itsj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import thanhtrong.itsj.exception.ErrorMessage;
import thanhtrong.itsj.exception.InvalidException;
import thanhtrong.itsj.exception.StudentAlreadyExistedException;
import thanhtrong.itsj.exception.StudentNotFoundException;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Wed, 7/6/2022
 * Time     : 14:15
 * Filename : ApiExceptionHandler
 *
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(StudentAlreadyExistedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage studentAlreadyExisted(Exception ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ErrorMessage(400, ex.getLocalizedMessage());
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage studentNotFound(Exception ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ErrorMessage(404, ex.getLocalizedMessage());
    }

    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage invalidInput(Exception ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ErrorMessage(400, ex.getLocalizedMessage());
    }
}
