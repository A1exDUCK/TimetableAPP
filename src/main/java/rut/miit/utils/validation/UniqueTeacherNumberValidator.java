
package rut.miit.utils.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import rut.miit.repositories.TeacherRepository;


public class UniqueTeacherNumberValidator implements ConstraintValidator<UniqueTeacherNumber, String>{
    private final TeacherRepository teacherRepository;

    public UniqueTeacherNumberValidator(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return teacherRepository.findByTeacherNumber(value).isEmpty();
    }
}
