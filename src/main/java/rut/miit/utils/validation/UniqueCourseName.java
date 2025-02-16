package rut.miit.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueLessonValidator.class)
public @interface UniqueCourseName {
    String message() default "Имя дисциплины уже занято!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}