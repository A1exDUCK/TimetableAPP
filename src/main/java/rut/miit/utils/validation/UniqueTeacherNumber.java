package rut.miit.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueTeacherNumberValidator.class)
public @interface UniqueTeacherNumber {
    String message() default "Преподаватель с таким номером уже существует!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
