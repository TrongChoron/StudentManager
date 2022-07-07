package thanhtrong.itsj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 6/30/2022
 * Time     : 16:04
 * Filename : StudentNotFoundException
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(){
    }

    public StudentNotFoundException(String message){
        super(message);
    }
}
