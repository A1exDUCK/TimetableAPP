package rut.miit.dto;

import java.time.LocalDate;

public class ShowLessonDto {
    private String id;
    private String studentGroup;
    private LocalDate date;
    private String selectedPair;
    private String classroom;
    private String courseName;
    private String teacherName;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSelectedPair() {
        return selectedPair;
    }
    public void setSelectedPair(String selectedPair) {
        this.selectedPair = selectedPair;
    }

    public String getClassroom() {return classroom;}
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getStudentGroup() {return studentGroup;}
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getCourseName() {return courseName;}
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {return teacherName;}
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
