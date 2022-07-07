package thanhtrong.itsj.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 6/30/2022
 * Time     : 15:56
 * Filename : StudentDTO
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String name;
    private String email;
    private String address;
    private String phone;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthDay;
}
