package rut.miit.dto;

import jakarta.validation.constraints.*;
import rut.miit.utils.validation.UniqueTeacherNumber;

public class AddTeacherDto {

    private String teacherName;
    @UniqueTeacherNumber
    private String teacherNumber;
    private String department;

    @NotEmpty(message = "Имя преподавателя обязательно!")
    public String getTeacherName() {return teacherName;}
    public void setTeacherName(String teacherName) {this.teacherName = teacherName;}

    @NotEmpty(message = "Номер преподавателя обязателен!")
    public String getTeacherNumber() {return teacherNumber;}
    public void setTeacherNumber(String teacherNumber) {this.teacherNumber = teacherNumber;}

    @NotEmpty(message = "Кафедра обязательна!")
    public String getDepartment() {return department;}
    public void setDepartment(String department) {this.department = department;}
}
