package rut.miit.utils.validation;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import rut.miit.dto.AddLessonDto;
import rut.miit.repositories.LessonRepository;

public class UniqueLessonValidator implements ConstraintValidator<UniqueLessonConstraint, AddLessonDto> {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public boolean isValid(AddLessonDto dto, ConstraintValidatorContext context) {
        return !lessonRepository.existsByDateAndSelectedPairAndClassroom(
                dto.getDate(),
                dto.getSelectedPair(),
                dto.getClassroom()
        );
    }
}