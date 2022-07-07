package thanhtrong.itsj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thanhtrong.itsj.entity.Student;

import java.util.List;
import java.util.Optional;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 6/30/2022
 * Time     : 15:55
 * Filename : StudentRepo
 */
@Repository
public interface StudentRepo extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {
    @Query(value = "SELECT * FROM student WHERE " +
            "name LIKE :query"+
            " or email like :query",
           nativeQuery = true)
    List<Student> searchStudents(String query);
    @Query(value = "SELECT * from student where email = :email",nativeQuery = true)
    Optional<Student> getStudentByEmail(@Param("email") String email);
}
