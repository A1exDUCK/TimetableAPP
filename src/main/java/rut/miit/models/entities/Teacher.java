package rut.miit.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Teachers")
public class Teacher extends rut.miit.models.entities.BaseEntity {
    private String teacherNumber;
    private String department;
    private Set <teacherName> teacherNames;
}
