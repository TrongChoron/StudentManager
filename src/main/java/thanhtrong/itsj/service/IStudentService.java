package thanhtrong.itsj.service;

import org.springframework.data.domain.Page;
import thanhtrong.itsj.dto.StudentDTO;
import thanhtrong.itsj.entity.Student;

import java.util.List;
import java.util.Optional;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 6/30/2022
 * Time     : 15:59
 * Filename : IStudentService
 */
public interface IStudentService {

    Page<Student> getStudentPaging(Optional<Integer> page, Optional<String> sortBy);

    List<Student> getAllStudent();

    Student addNewStudent(StudentDTO studentDTO);

    Student getStudentById(Long id);

    Student updateStudent(Long id, StudentDTO studentDTO);

    void deleteStudent(Long id);

    List<Student> searchStudents(String query);

    Page<Student> searchStudentPaging(Optional<Integer> page, Optional<String> sortBy);
}
