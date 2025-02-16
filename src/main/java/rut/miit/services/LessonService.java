package rut.miit.services;

import rut.miit.dto.AddLessonDto;
import rut.miit.dto.ShowLessonDto;

import java.time.LocalDate;
import java.util.List;

public interface LessonService {
    void addLesson(AddLessonDto addLessonDto);

    List<ShowLessonDto> allLessons();

    void removeLesson(LocalDate date, String selectedPair, String classroom);
}