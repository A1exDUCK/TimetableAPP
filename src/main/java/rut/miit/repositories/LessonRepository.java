package rut.miit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.models.entities.Lesson;
import java.time.LocalDate;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, String> {

    boolean existsByDateAndSelectedPairAndClassroom(
            LocalDate date,
            String selectedPair,
            String classroom
    );

    @Modifying
    @Transactional
    @Query("DELETE FROM Lesson l WHERE l.id = :id")
    void deleteById(@Param("id") String id);
}