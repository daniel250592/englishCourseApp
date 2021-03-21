package sda.ispeak.prework.models.validations.question;

import sda.ispeak.prework.models.dtos.question.NewQuestionDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class DifferentQuestionsValidatorImpl implements ConstraintValidator<DifferentQuestionsValidator, NewQuestionDto> {

    @Override
    public boolean isValid(NewQuestionDto newQuestionDto, ConstraintValidatorContext constraintValidatorContext) {
        Set<String> answers = new HashSet<>();
                answers.add(newQuestionDto.getFirstAnswerContent());
                answers.add(newQuestionDto.getSecondAnswerContent());
                answers.add(newQuestionDto.getThirdAnswerContent());
                answers.add(newQuestionDto.getFourthAnswerContent());


        return answers.size() == 4;
    }

}
