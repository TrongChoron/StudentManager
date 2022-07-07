package thanhtrong.itsj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 7/7/2022
 * Time     : 10:21
 * Filename : InvalidException
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidException extends RuntimeException{
    public InvalidException(){
    }

    public InvalidException(String message){
        super(message);
    }
}
