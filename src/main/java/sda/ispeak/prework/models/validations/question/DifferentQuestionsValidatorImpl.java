package sda.ispeak.prework.models.validations.question;

import sda.ispeak.prework.models.dtos.question.NewQuestionDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DifferentQuestionsValidatorImpl implements ConstraintValidator<DifferentQuestionsValidator, NewQuestionDto> {

    @Override
    public boolean isValid(NewQuestionDto newQuestionDto, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if((!(newQuestionDto.getFirstAnswerContent()
                .equals(newQuestionDto.getSecondAnswerContent())))
                || (!(newQuestionDto.getFirstAnswerContent()
                .equals(newQuestionDto.getThirdAnswerContent())))
                || (!(newQuestionDto.getFirstAnswerContent()
                .equals(newQuestionDto.getFourthAnswerContent())))
                || (!(newQuestionDto.getSecondAnswerContent()
                .equals(newQuestionDto.getThirdAnswerContent())))
                || (!(newQuestionDto.getSecondAnswerContent()
                .equals(newQuestionDto.getFourthAnswerContent())))
                || (!(newQuestionDto.getThirdAnswerContent()
                .equals(newQuestionDto.getFourthAnswerContent())))) {

            return isValid = true;
        }
        return isValid;
    }

}
