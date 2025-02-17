package rut.miit.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.dto.AddCourseDto;
import rut.miit.dto.ShowCourseDto;
import rut.miit.repositories.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void addCourse(AddCourseDto addCourseDto) {

    }

    @Override
    public List<ShowCourseDto> allCourses() {return List.of();}

    @Override
    @Transactional
    public void removeCourse(String courseName) {
        courseRepository.deleteByCourseName(courseName);
    }
}
