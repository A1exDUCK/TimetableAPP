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

    // Список всех пар
    public static final List<String> PAIRS = List.of(
            "1 пара — 08:30 – 09:50",
            "2 пара — 10:05 – 11:25",
            "3 пара — 11:40 – 13:00",
            "4 пара — 13:45 – 15:05",
            "5 пара — 15:20 – 16:40",
            "6 пара — 16:55 – 18:15",
            "7 пара — 18:30 – 19:50",
            "8 пара — 20:00 – 21:20"
    );

    @ManyToOne
    private Course course;

    @Column
    public String getStudentGroup() {return studentGroup;}
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Column
    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column
    public String getSelectedPair() {return selectedPair;}
    public void setSelectedPair(String selectedPair) {
        this.selectedPair = selectedPair;
    }

    @Column
    public String getClassroom() {return classroom;}
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    public Course getCourse() {return course;}
    public void setCourse(Course courseName) {this.course = courseName;}

}
