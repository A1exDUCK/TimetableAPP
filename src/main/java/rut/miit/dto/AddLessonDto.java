package rut.miit.dto;

import jakarta.validation.constraints.*;
import rut.miit.utils.validation.UniqueLessonConstraint;

import java.time.LocalDate;

@UniqueLessonConstraint
public class AddLessonDto {
    private LocalDate date;
    private String selectedPair;
    private String classroom;

    // Геттеры и сеттеры с базовыми ограничениями
    @NotNull(message = "Дата обязательна!")
    public LocalDate getDate() {
        return date;
    }

    @NotBlank(message = "Номер пары обязателен!")
    public String getSelectedPair() {
        return selectedPair;
    }

    @NotBlank(message = "Аудитория обязательна!")
    @Size(max = 4, message = "Номер аудитории не длиннее 4 символов!")
    public String getClassroom() {
        return classroom;
    }

    // Сеттеры
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSelectedPair(String selectedPair) {
        this.selectedPair = selectedPair;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
