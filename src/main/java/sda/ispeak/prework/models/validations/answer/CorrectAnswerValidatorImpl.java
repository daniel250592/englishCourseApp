package sda.ispeak.prework.models.validations.answer;

import sda.ispeak.prework.models.dtos.question.NewQuestionDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectAnswerValidatorImpl implements ConstraintValidator<CorrectAnswerValidator, NewQuestionDto> {

    @Override
    public boolean isValid(NewQuestionDto newQuestionDto, ConstraintValidatorContext constraintValidatorContext) {

        int count = newQuestionDto.isFirstCorrect() ? 1 : 0;
        count += newQuestionDto.isSecondCorrect() ? 1 : 0;
        count += newQuestionDto.isThirdCorrect() ? 1 : 0;
        count += newQuestionDto.isFourthCorrect() ? 1 : 0;
        return count == 1;
    }
}
