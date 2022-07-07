package thanhtrong.itsj.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Wed, 7/6/2022
 * Time     : 14:21
 * Filename : ErrorMessage
 */
@Data
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private String message;
}
