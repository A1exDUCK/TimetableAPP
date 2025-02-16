package rut.miit.dto;

import jakarta.validation.constraints.*;
import rut.miit.utils.validation.UniqueTeacherNumber;
public class AddTeacherDto {

    private String teacherName;
    @UniqueTeacherNumber
    private Integer teacherNumber;
    private String department;

    @NotEmpty(message = "Имя преподавателя обязательно!")
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @NotNull(message = "Номер преподавателя обязателен!")
    @Size(min = 7, max = 7, message = "Номер преподавателя должен быть в формате 123456")
    public Integer getTeacherNumber() {
        return teacherNumber;
    }
    public void setTeacherNumber(Integer teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    @NotEmpty(message = "Кафедра обязательна!")
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
