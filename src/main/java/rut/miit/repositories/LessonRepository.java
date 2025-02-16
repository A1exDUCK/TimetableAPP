package rut.miit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.models.entities.Course;
import rut.miit.models.entities.Lesson;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, String> {

    Optional<Lesson> findByCourse(Course courseName);
    Optional<Lesson> findByDate(LocalDate date);
    Optional<Lesson> findByClassroom(String Classroom);
    Optional<Lesson> findBySelectedPair(String  SelectedPair);

    @Modifying
    @Transactional
    @Query("DELETE FROM Lesson WHERE date=:date AND selectedPair=:selectedPair")
    void deleteByDateAndSelectedPair(LocalDate date, String selectedPair);
}