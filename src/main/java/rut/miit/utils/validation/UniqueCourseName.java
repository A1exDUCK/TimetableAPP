package rut.miit.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueCourseNameValidator.class) // Убедитесь, что указывает на правильный валидатор
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCourseName {
    String message() default "Такая дисциплина уже существует";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}