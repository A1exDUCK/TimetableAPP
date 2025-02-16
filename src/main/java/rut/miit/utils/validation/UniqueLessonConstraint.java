package rut.miit.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueLessonValidator.class)
public @interface UniqueLessonConstraint {
    String message() default "Аудитория уже занята в это время!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}