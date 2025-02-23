package rut.miit.services;

import rut.miit.dto.AddTeacherDto;
import rut.miit.dto.ShowTeacherDto;

import java.util.List;

public interface TeacherService {

    void addTeacher(AddTeacherDto addTeacherDto);

    List<ShowTeacherDto> allTeachers();

    void removeTeacher(String teacherNumber);
}