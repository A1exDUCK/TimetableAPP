package rut.miit.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course extends rut.miit.models.entities.BaseEntity {

    private String courseName;

    private Set<Lesson> lessons;

    public Course() {lessons = new HashSet<>();}
    
    @ManyToOne
    private Teacher teacher;

    @Column
    public String getCourseName() {return courseName;}
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    @OneToMany (mappedBy ="course", targetEntity = Lesson.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Lesson> getLessons(){return lessons;}
    public void setLessons(Set<Lesson> lessons){this.lessons = lessons;}

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    public Teacher getTeacher() {return teacher;}
    public void setTeacher(Teacher teacherName) {this.teacher = teacherName;}
}