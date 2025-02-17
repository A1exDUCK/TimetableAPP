package rut.miit.dto;

import jakarta.validation.constraints.*;
import rut.miit.utils.validation.UniqueCourseName;


public class AddCourseDto {

    @NotEmpty(message = "Имя дисциплины обязательно!")
    @UniqueCourseName
    private String courseName;
    public String getCourseName() {return courseName;}
    public void setCourseName(String courseName) {this.courseName = courseName;}

    @NotEmpty(message = "Имя преподавателя обязательно!")
    private String teacherName;
    public String getTeacherName() {return teacherName;}
    public void setTeacherName(String teacherName) {this.teacherName = teacherName;}

    @Override
    public String toString() {
        return "AddCourseDto{" +
                "courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
