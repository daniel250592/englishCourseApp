package sda.ispeak.prework.models.validations.samePasswordsVlidator;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import sda.ispeak.prework.models.dtos.question.NewQuestionDto;
import sda.ispeak.prework.models.validations.question.DifferentQuestionsValidatorImpl;

import javax.validation.ConstraintValidatorContext;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferentQuestionValidatorTest {


    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    private final DifferentQuestionsValidatorImpl differentQuestionsValidator = new DifferentQuestionsValidatorImpl();

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

        boolean valid = differentQuestionsValidator.isValid(newQuestionDto, constraintValidatorContext);

        assertThat(valid).isTrue();
    }

    @Test
    void shouldAssertFalse() {
        NewQuestionDto newQuestionDto = NewQuestionDto.builder()
                .id(2L)
                .question("Example question")
                .firstAnswerContent("A")
                .secondAnswerContent("C")
                .thirdAnswerContent("C")
                .fourthAnswerContent("D")
                .firstCorrect(false)
                .secondCorrect(false)
                .thirdCorrect(false)
                .fourthCorrect(true)
                .build();

        boolean valid = differentQuestionsValidator.isValid(newQuestionDto, constraintValidatorContext);

        assertThat(valid).isFalse();
    }

}
