package thanhtrong.itsj.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import thanhtrong.itsj.dto.StudentDTO;
import thanhtrong.itsj.entity.Student;
import thanhtrong.itsj.exception.InvalidException;
import thanhtrong.itsj.exception.StudentAlreadyExistedException;
import thanhtrong.itsj.exception.StudentNotFoundException;
import thanhtrong.itsj.repository.StudentRepo;
import thanhtrong.itsj.service.IStudentService;

import java.util.List;
import java.util.Optional;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 6/30/2022
 * Time     : 16:00
 * Filename : StudentServiceImpl
 */
@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private final StudentRepo studentRepo;

    @Override
    public Page<Student> getStudentPaging(Optional<Integer> page, Optional<String> sortBy) {
        return studentRepo.findAll(
                PageRequest.of(
                        page.orElse(0),
                        5,
                        Sort.Direction.ASC, sortBy.orElse("id")
                ));
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student addNewStudent(StudentDTO studentDTO) {
        String email = studentDTO.getEmail();
        boolean studentExist = studentRepo.getStudentByEmail(email).isPresent();
        if(studentExist){
            throw new StudentAlreadyExistedException(String.format("Student with email %s already existed",email));
        }else {
            Student student = new Student();
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());
            student.setAddress(studentDTO.getAddress());
            student.setPhone(studentDTO.getPhone());
            student.setBirthDay(studentDTO.getBirthDay());
            if(checkAge(student.getAge())) {
                studentRepo.save(student);
            }else {
                throw new InvalidException("Student must in 18 - 80 years old!!!");
            }
            return student;
        }
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(()-> new StudentNotFoundException
                        (String.format("Student with id = %d has not existed in DB",id)));
    }

    @Override
    public Student updateStudent(Long id, StudentDTO studentDTO) {
        Student student =
                studentRepo.findById(id)
                        .orElseThrow(()-> new StudentNotFoundException
                                (String.format("Student with id = %d has not existed in DB",id)));
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setAddress(studentDTO.getAddress());
        student.setPhone(studentDTO.getPhone());
        student.setBirthDay(studentDTO.getBirthDay());
        if(checkAge(student.getAge())) {
            studentRepo.save(student);
        }else {
            throw new InvalidException("Student must in 18 - 80 years old!!!");
        }
        studentRepo.save(student);
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        Student student =
                studentRepo.findById(id)
                        .orElseThrow(()-> new StudentNotFoundException
                                (String.format("Student with id = %d has not existed in DB",id)));
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> searchStudents(String query) {
        List<Student> students = studentRepo.searchStudents(query);
        return students;
    }

    @Override
    public Page<Student> searchStudentPaging(Optional<Integer> page, Optional<String> sortBy) {
        return studentRepo.findAll(
                PageRequest.of(
                        page.orElse(0),
                        5,
                        Sort.Direction.ASC, sortBy.orElse("id")
                ));
    }

    private boolean checkAge(int age){
        return age > 18 && age < 80;
    }
}
