package rut.miit.dto;

import jakarta.validation.constraints.*;
import rut.miit.utils.validation.UniqueCourseName;

@UniqueCourseName
public class AddCourseDto {
    private String courseName;

    @NotBlank(message = "Имя дисциплины обязательно!")
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
