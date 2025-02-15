package rut.miit.models.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends rut.miit.models.entities.BaseEntity {

    private String teacherName;
    private Integer teacherNumber;
    private String department;
    private Set<Teacher> teachers;

@Column(unique = true,nullable = false)
public String getTeacherName() {
    return teacherName;
}
public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
}

@Column(unique = true,nullable = false,length = 7)
    public Integer getTeacherNumber() {return teacherNumber;}
    public void setTeacherNumber(Integer teacherNumber) {this.teacherNumber = teacherNumber;}

@Column(unique = false,nullable = true)
    public String getDepartment() {return department;}
    public void setDepartment(String department) {this.department = department;}

    @OneToMany (mappedBy ="teacher", targetEntity = Teacher.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Teacher> getTeachers(){return teachers;}
    public void setTeachers(Set<Teacher> teachers){this.teachers = teachers;}
}