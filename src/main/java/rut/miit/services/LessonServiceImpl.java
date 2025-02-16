package rut.miit.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.dto.AddLessonDto;
import rut.miit.dto.ShowLessonDto;
import rut.miit.repositories.LessonRepository;
import rut.miit.services.LessonService;

import java.time.LocalDate;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void addLesson(AddLessonDto addLessonDto) {

    }

    @Override
    public List<ShowLessonDto> allLessons() {
        return List.of();
    }

    @Override
    @Transactional
    public void removeLesson(LocalDate date, String selectedPair, String classroom) {
        lessonRepository.deleteByDateAndSelectedPairAndClassroom(date, selectedPair, classroom);
    }

}