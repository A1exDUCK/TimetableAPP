package rut.miit.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.dto.AddCourseDto;
import rut.miit.dto.ShowCourseDto;
import rut.miit.models.entities.Course;
import rut.miit.repositories.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper mapper;

    public CourseServiceImpl(CourseRepository courseRepository, ModelMapper mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    @Override
    public void addCourse(AddCourseDto addCourseDto) {
        courseRepository.saveAndFlush(mapper.map(addCourseDto, Course.class));

    }

    @Override
    public List<ShowCourseDto> allCourses() {
        return courseRepository.findAll().stream().map(course -> mapper.map(course, ShowCourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removeCourse(String courseName) {
        courseRepository.deleteByCourseName(courseName);
    }
}
