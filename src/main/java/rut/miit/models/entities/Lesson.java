package rut.miit.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson extends BaseEntity {
    private String studentGroup;
    private LocalDate date;
    private String selectedPair;
    private String classroom;

    @ManyToOne
    private Course course;

    @Column(unique = false,nullable = true)
    public String getStudentGroup() {return studentGroup;}
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Column(unique = false,nullable = true)
    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(unique = false,nullable = true)
    public String getSelectedPair() {return selectedPair;}
    public void setSelectedPair(String selectedPair) {
        this.selectedPair = selectedPair;
    }

    @Column(unique = false,nullable = true)
    public String getClassroom() {return classroom;}
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    public Course getCourse() {return course;}
    public void setCourse(Course courseName) {this.course = courseName;}

}
