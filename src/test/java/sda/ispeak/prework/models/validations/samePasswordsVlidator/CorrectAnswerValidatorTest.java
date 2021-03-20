package sda.ispeak.prework.models.validations.samePasswordsVlidator;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import sda.ispeak.prework.models.dtos.question.NewQuestionDto;
import sda.ispeak.prework.models.validations.answer.CorrectAnswerValidatorImpl;

import javax.validation.ConstraintValidatorContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CorrectAnswerValidatorTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    private final CorrectAnswerValidatorImpl correctAnswerValidator = new CorrectAnswerValidatorImpl();

    @Test
    void shouldAssertTrue() {

        NewQuestionDto newQuestionDto = NewQuestionDto.builder()
                .id(1L)
                .question("Example question")
                .firstAnswerContent("A")
                .secondAnswerContent("B")
                .thirdAnswerContent("C")
                .fourthAnswerContent("D")
                .firstCorrect(false)
                .secondCorrect(false)
                .thirdCorrect(true)
                .fourthCorrect(false)
                .build();

        boolean valid = correctAnswerValidator.isValid(newQuestionDto, constraintValidatorContext);

        assertThat(valid).isTrue();
    }

    @Test
    void shouldAssertFalse() {

        NewQuestionDto newQuestionDto = NewQuestionDto.builder()
                .id(1L)
                .question("Example question")
                .firstAnswerContent("A")
                .secondAnswerContent("B")
                .thirdAnswerContent("C")
                .fourthAnswerContent("D")
                .firstCorrect(true)
                .secondCorrect(false)
                .thirdCorrect(true)
                .fourthCorrect(false)
                .build();

        boolean valid = correctAnswerValidator.isValid(newQuestionDto, constraintValidatorContext);

        assertThat(valid).isFalse();
    }
}
