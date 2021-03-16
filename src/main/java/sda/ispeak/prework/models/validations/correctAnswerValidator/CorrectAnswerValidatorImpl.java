package sda.ispeak.prework.models.validations.correctAnswerValidator;

import sda.ispeak.prework.models.dtos.question.NewQuestionDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CorrectAnswerValidatorImpl implements ConstraintValidator<CorrectAnswerValidator, NewQuestionDto> {


    @Override
    public boolean isValid(NewQuestionDto newQuestionDto, ConstraintValidatorContext constraintValidatorContext) {
        List<Boolean> booleanList = new ArrayList<>();
        booleanList.add(newQuestionDto.isFirstCorrect());
        booleanList.add(newQuestionDto.isSecondCorrect());
        booleanList.add(newQuestionDto.isThirdCorrect());
        booleanList.add(newQuestionDto.isFourthCorrect());

        long count = booleanList.stream().filter(answer -> answer).count();

        return count == 1;
    }
}