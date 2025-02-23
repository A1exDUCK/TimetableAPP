package rut.miit.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.dto.AddLessonDto;
import rut.miit.dto.ShowLessonDto;
import rut.miit.models.entities.Course;
import rut.miit.models.entities.Lesson;
import rut.miit.models.entities.Teacher;
import rut.miit.repositories.CourseRepository;
import rut.miit.repositories.LessonRepository;
import rut.miit.repositories.TeacherRepository;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper mapper;

    public LessonServiceImpl(LessonRepository lessonRepository,CourseRepository courseRepository, ModelMapper mapper) {
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;


        this.mapper = mapper;
    }

    @Transactional
    public void addLesson(AddLessonDto addLessonDto) {
        Lesson lesson = mapper.map(addLessonDto, Lesson.class);

        // Получаем связанные сущности
        Course course = courseRepository.findById(addLessonDto.getCourseName())
                .orElseThrow((null));

        Teacher teacher = course.getTeacher();

        // Устанавливаем связи
        lesson.setCourse(course);
        lesson.setTeacher(teacher);

        lessonRepository.saveAndFlush(lesson);
    }

    @Override
    public List<ShowLessonDto> allLessons() {
        return lessonRepository.findAll().stream().map(lesson -> mapper.map(lesson, ShowLessonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removeLesson(String id) {
        lessonRepository.deleteById(id);
    }

}