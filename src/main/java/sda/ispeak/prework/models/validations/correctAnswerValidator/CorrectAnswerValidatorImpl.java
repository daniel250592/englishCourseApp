package sda.ispeak.prework.models.validations.correctAnswerValidator;

import sda.ispeak.prework.models.dtos.question.NewQuestionDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectAnswerValidatorImpl implements ConstraintValidator<CorrectAnswerValidator, NewQuestionDto> {

    @Override
    public boolean isValid(NewQuestionDto newQuestionDto, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
    //TODO - zrobić tak by TRUE gdy DOKŁADNIE jedna odp poprawna
}
