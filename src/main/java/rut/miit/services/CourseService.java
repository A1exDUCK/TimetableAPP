package rut.miit.services;

import rut.miit.dto.AddCourseDto;
import rut.miit.dto.ShowCourseDto;

import java.util.List;

public interface CourseService {
    void addCourse(AddCourseDto addCourseDto);

    List<ShowCourseDto> allCourses();

    void removeCourse(String courseName);
}
