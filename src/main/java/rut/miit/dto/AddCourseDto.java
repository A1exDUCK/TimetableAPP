package rut.miit.dto;

import jakarta.validation.constraints.*;

public class AddCourseDto {

    private String courseName;
    private String teacherName;

    @NotEmpty(message = "Имя дисциплины обязательно!")
    public String getCourseName() {return courseName;}
    public void setCourseName(String courseName) {this.courseName = courseName;}

    @NotEmpty(message = "Имя преподавателя обязательно!")
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