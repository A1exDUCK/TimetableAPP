package rut.miit.dto;

import jakarta.validation.constraints.*;
import rut.miit.utils.validation.UniqueCourseName;

@UniqueCourseName
public class AddCourseDto {

    private String courseName;
    private String teacherName;

    @NotEmpty(message = "Имя дисциплины обязательно!")
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @NotEmpty(message = "Имя преподавателя обязательно!")
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

}
