package rut.miit.dto;

import jakarta.validation.constraints.*;
import rut.miit.utils.validation.UniqueLessonConstraint;
import java.time.LocalDate;

@UniqueLessonConstraint
public class AddLessonDto {

    private String studentGroup;
    private LocalDate date;
    private String selectedPair;
    private String classroom;
    private String courseName;
    private String teacherName;

    @NotNull(message = "Дата обязательна!")
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @NotEmpty(message = "Номер пары обязателен!")
    public String getSelectedPair() {
        return selectedPair;
    }
    public void setSelectedPair(String selectedPair) {
        this.selectedPair = selectedPair;
    }

    @NotEmpty(message = "Аудитория обязательна!")
    public String getClassroom() {return classroom;}
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @NotEmpty(message = "Номер группы обязателен!")
    public String getStudentGroup() {return studentGroup;}
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    @NotEmpty(message = "Имя дисциплины обязательно!")
    public String getCourseName() {return courseName;}
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {return teacherName;}
    public void setTeacherName(String teacherName) {this.teacherName = teacherName;}
}