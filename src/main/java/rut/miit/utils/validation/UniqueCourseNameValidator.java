package rut.miit.utils.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import rut.miit.repositories.CourseRepository;


public class UniqueCourseNameValidator implements ConstraintValidator<UniqueCourseName, String>{
    private final CourseRepository courseRepository;

    public UniqueCourseNameValidator(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return courseRepository.findByCourseName(value).isEmpty();
    }
}
