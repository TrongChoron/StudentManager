package thanhtrong.itsj.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import thanhtrong.itsj.entity.Student;
import thanhtrong.itsj.repository.StudentRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 7/7/2022
 * Time     : 09:18
 * Filename : StudentRepoTest
 */
@SpringBootTest
public class StudentRepoTest {
    @Autowired
    private StudentRepo studentRepo;

    @Test
    void isPersonExitsById() {
        Date dateInsert = parseDate("06/07/2001");
        Student student = new Student();
        student.setName("Trong");
        student.setEmail("tronglagi111@gmail.com");
        student.setAddress("46 Le Duc Tho");
        student.setBirthDay(dateInsert);
        student.setPhone("0352484762");
        studentRepo.save(student);
        Boolean actualResult = studentRepo.findById(1L)
                .isPresent();
        assertThat(actualResult).isTrue();
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
