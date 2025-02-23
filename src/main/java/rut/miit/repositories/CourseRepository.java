package rut.miit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.models.entities.Course;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    Optional<Course> findById(String id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Course c WHERE c.id = :id")
    void deleteById(@Param("id") String id);
}