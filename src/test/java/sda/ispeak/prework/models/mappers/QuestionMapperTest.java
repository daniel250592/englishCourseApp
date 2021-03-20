package sda.ispeak.prework.models.mappers;

import org.junit.jupiter.api.Test;
import sda.ispeak.prework.models.dtos.question.NewQuestionDto;
import sda.ispeak.prework.models.dtos.question.QuestionProfileDto;
import sda.ispeak.prework.models.entities.questions.Question;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuestionMapperTest {
    @Test
    void shouldMapToNewQuestionDto() {

        NewQuestionDto newQuestionDto = NewQuestionDto.builder()
                .id(1L)
                .question("Example question")
                .firstAnswerContent("A")
                .secondAnswerContent("B")
                .thirdAnswerContent("C")
                .fourthAnswerContent("D")
                .firstCorrect(false)
                .secondCorrect(true)
                .thirdCorrect(false)
                .fourthCorrect(false)
                .build();

        Question question = QuestionMapper.map(newQuestionDto);

        assertThat(newQuestionDto.getId()).isEqualTo(question.getId());
        assertThat(newQuestionDto.getQuestion()).isEqualTo(question.getQuestion());
        assertThat(newQuestionDto.getFirstAnswerContent()).isEqualTo(question.getFirstAnswerContent());
        assertThat(newQuestionDto.getSecondAnswerContent()).isEqualTo(question.getSecondAnswerContent());
        assertThat(newQuestionDto.getThirdAnswerContent()).isEqualTo(question.getThirdAnswerContent());
        assertThat(newQuestionDto.getFourthAnswerContent()).isEqualTo(question.getFourthAnswerContent());
        assertThat(newQuestionDto.isFirstCorrect()).isEqualTo(question.isFirstCorrect());
        assertThat(newQuestionDto.isSecondCorrect()).isEqualTo(question.isSecondCorrect());
        assertThat(newQuestionDto.isThirdCorrect()).isEqualTo(question.isThirdCorrect());
        assertThat(newQuestionDto.isFourthCorrect()).isEqualTo(question.isFourthCorrect());
    }
    @Test
    void shouldMapToQustion() {

        Question question = Question.builder()
                .id(1L)
                .question("Example question")
                .firstAnswerContent("A")
                .secondAnswerContent("B")
                .thirdAnswerContent("C")
                .fourthAnswerContent("D")
                .firstCorrect(false)
                .secondCorrect(true)
                .thirdCorrect(false)
                .fourthCorrect(false)
                .build();

        QuestionProfileDto questionProfileDto = QuestionMapper.map(question);

        assertThat(questionProfileDto.getId()).isEqualTo(question.getId());
        assertThat(questionProfileDto.getQuestion()).isEqualTo(question.getQuestion());
        assertThat(questionProfileDto.getFirstAnswerContent()).isEqualTo(question.getFirstAnswerContent());
        assertThat(questionProfileDto.getSecondAnswerContent()).isEqualTo(question.getSecondAnswerContent());
        assertThat(questionProfileDto.getThirdAnswerContent()).isEqualTo(question.getThirdAnswerContent());
        assertThat(questionProfileDto.getFourthAnswerContent()).isEqualTo(question.getFourthAnswerContent());
        assertThat(questionProfileDto.isFirstCorrect()).isEqualTo(question.isFirstCorrect());
        assertThat(questionProfileDto.isSecondCorrect()).isEqualTo(question.isSecondCorrect());
        assertThat(questionProfileDto.isThirdCorrect()).isEqualTo(question.isThirdCorrect());
        assertThat(questionProfileDto.isFourthCorrect()).isEqualTo(question.isFourthCorrect());
    }

}
