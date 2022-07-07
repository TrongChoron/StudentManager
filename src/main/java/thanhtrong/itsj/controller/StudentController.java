package thanhtrong.itsj.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import thanhtrong.itsj.dto.StudentDTO;
import thanhtrong.itsj.entity.Student;
import thanhtrong.itsj.service.IStudentService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Fri, 7/1/2022
 * Time     : 09:11
 * Filename : StudentController
 */
@Controller
@RequestMapping("api/v1")
@AllArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    // GET find all student
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok().body(studentService.getAllStudent());
    }

    // POST add new student
    @PostMapping("/student")
    public ResponseEntity<Student> addNewStudent(@RequestBody StudentDTO studentDTO){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/student/save").toUriString());
        return ResponseEntity.created(uri).body(studentService.addNewStudent(studentDTO));
    }

    // GET find student by ID
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> addNewStudent(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }


    // GET find all student has paging
    @GetMapping("/paging")
    public ResponseEntity<List<Student>> getStudentPaging(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy){
        Page<Student> abc = studentService.getStudentPaging(page,sortBy);
        return ResponseEntity.ok().body(abc.toList());
    }

    // PUT update student
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,@RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok().body(studentService.updateStudent(id,studentDTO));
    }

    // DELETE delete student
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().body(String.format("Student with id = %d has been deleted",id));
    }

    //GET search Student
    @GetMapping("/students/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam("query") String query){
        return ResponseEntity.ok(studentService.searchStudents(query));
    }

    @GetMapping("/students/search/paging")
    public ResponseEntity<List<Student>> searchStudentsPaging(@RequestParam("query") String query){
        return ResponseEntity.ok(studentService.searchStudents(query));
    }
}
