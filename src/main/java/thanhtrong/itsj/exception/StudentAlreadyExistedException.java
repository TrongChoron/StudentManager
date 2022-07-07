package thanhtrong.itsj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 6/30/2022
 * Time     : 16:02
 * Filename : StudentAlreadyExistedException
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentAlreadyExistedException extends RuntimeException{
    public StudentAlreadyExistedException(){
    }

    public StudentAlreadyExistedException(String message){
        super(message);
    }
}
