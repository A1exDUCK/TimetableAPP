package rut.miit.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.dto.AddLessonDto;
import rut.miit.dto.ShowLessonDto;
import rut.miit.models.entities.Lesson;
import rut.miit.repositories.LessonRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final ModelMapper mapper;

    public LessonServiceImpl(LessonRepository lessonRepository, ModelMapper mapper) {
        this.lessonRepository = lessonRepository;
        this.mapper = mapper;
    }

    @Override
    public void addLesson(AddLessonDto addLessonDto) {
        lessonRepository.saveAndFlush(mapper.map(addLessonDto, Lesson.class));
    }

    @Override
    public List<ShowLessonDto> allLessons() {
        return lessonRepository.findAll().stream().map(lesson -> mapper.map(lesson, ShowLessonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removeLesson(LocalDate date, String selectedPair, String classroom) {
        lessonRepository.deleteByDateAndSelectedPairAndClassroom(date, selectedPair, classroom);
    }

}