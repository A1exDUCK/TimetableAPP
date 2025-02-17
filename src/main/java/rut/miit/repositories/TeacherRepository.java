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

    Optional<Teacher> findByTeacherNumber(String teacherNumber);

    @Modifying
    @Transactional
    @Query("DELETE FROM Teacher WHERE teacherName=:teacherNumber")
    void deleteByTeacherNumber(String teacherNumber);
}