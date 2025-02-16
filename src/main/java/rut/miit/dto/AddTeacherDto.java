package rut.miit.dto;

import jakarta.validation.constraints.*;
import rut.miit.utils.validation.UniqueTeacherNumber;
public class AddTeacherDto {

    private String teacherName;
    @UniqueTeacherNumber
    private Integer teacherNumber;
    private String department;

    @NotEmpty(message = "Teacher name must not be null or empty!")
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @NotNull(message = "Passing score cannot be null or empty!")
    @Size(min = 7, max = 7, message = "Teacher number must be like 123456")
    public Integer getTeacherNumber() {
        return teacherNumber;
    }
    public void setTeacherNumber(Integer teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    @NotEmpty(message = "Department cannot be null or empty!")
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}

