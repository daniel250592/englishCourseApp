package sda.ispeak.prework.models.mappers;

import org.junit.jupiter.api.Test;
import sda.ispeak.prework.models.forms.FourAnswersForm;
import sda.ispeak.prework.models.questions.Answer;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FourAnswerMapperTest {

    @Test
    void shouldMapToAnswersList() {

        FourAnswersForm fourAnswersForm = new FourAnswersForm();

        fourAnswersForm.setFirstAnswerContent("first test text");
        fourAnswersForm.setFirstCorrect(false);

        fourAnswersForm.setSecondAnswerContent("second test text");
        fourAnswersForm.setSecondCorrect(true);

        fourAnswersForm.setThirdAnswerContent("third test text");
        fourAnswersForm.setThirdCorrect(false);

        fourAnswersForm.setFourthAnswerContent("fourth test text");
        fourAnswersForm.setFourthCorrect(false);

        List<Answer> answers = FourAnswersMapper.map(fourAnswersForm);

        assertThat(answers.
                get(0)
                .getAnswerContent())
                .isEqualTo(fourAnswersForm.getFirstAnswerContent());
        assertThat(answers.
                get(0)
                .isCorrect())
                .isEqualTo(fourAnswersForm.isFirstCorrect());
        assertThat(answers.
                get(1)
                .getAnswerContent())
                .isEqualTo(fourAnswersForm.getSecondAnswerContent());
        assertThat(answers.
                get(1)
                .isCorrect())
                .isEqualTo(fourAnswersForm.isSecondCorrect());
        assertThat(answers.
                get(2)
                .getAnswerContent())
                .isEqualTo(fourAnswersForm.getThirdAnswerContent());
        assertThat(answers.
                get(2)
                .isCorrect())
                .isEqualTo(fourAnswersForm.isThirdCorrect());
        assertThat(answers.
                get(3)
                .getAnswerContent())
                .isEqualTo(fourAnswersForm.getFourthAnswerContent());
        assertThat(answers.
                get(3)
                .isCorrect())
                .isEqualTo(fourAnswersForm.isFourthCorrect());
    }
}
