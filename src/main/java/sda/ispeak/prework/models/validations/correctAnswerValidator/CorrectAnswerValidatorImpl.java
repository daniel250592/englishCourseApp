package sda.ispeak.prework.models.validations.correctAnswerValidator;

import sda.ispeak.prework.models.dtos.QuestionDto;
import sda.ispeak.prework.models.dtos.user.UserDto;
import sda.ispeak.prework.models.validations.theSamePasswordsVlidator.TheSamePasswordsValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectAnswerValidatorImpl implements ConstraintValidator<CorrectAnswerValidator, QuestionDto> {
    @Override
    public void initialize(CorrectAnswerValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(QuestionDto questionDto, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
    //TODO - zrobić tak by TRUE gdy DOKŁADNIE jedna odp poprawna
}
