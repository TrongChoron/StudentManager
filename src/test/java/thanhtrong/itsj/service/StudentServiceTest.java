package thanhtrong.itsj.service;


import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import thanhtrong.itsj.repository.StudentRepo;
import thanhtrong.itsj.service.impl.StudentServiceImpl;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 7/7/2022
 * Time     : 09:19
 * Filename : StudentServiceTest
 */
@SpringBootTest
public class StudentServiceTest {
    @Mock
    private StudentRepo studentRepo;

    private IStudentService studentService;

    @BeforeEach
    void setUp()
    {
        this.studentService
                = new StudentServiceImpl(this.studentRepo);
    }
    @Test
    void getAllStudent()
    {
        studentService.getAllStudent();
        verify(studentRepo).findAll();
    }

}
