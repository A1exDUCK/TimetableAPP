package rut.miit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.models.entities.Teacher;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

    Optional<Teacher> findByTeacherName(String teacherName);
    Optional<Teacher> findByTeacherNumber(String teacherNumber);
    Optional<Teacher> findByDepartment(String department);

    @Modifying
    @Transactional
    @Query("DELETE FROM Teacher WHERE teacherName=:teacherNumber")
    void deleteByTeacherNumber( String teacherNumber);
}