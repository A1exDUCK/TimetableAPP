package rut.miit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.models.entities.Course;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    Optional<Course> findByCourseName(String CourseName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Course WHERE courseName=:courseName")
    void deleteByCourseName(String courseName);

}
