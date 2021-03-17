package sda.ispeak.prework.models.mappers;

import org.junit.jupiter.api.Test;
import sda.ispeak.prework.models.dtos.AnswerDto;
import sda.ispeak.prework.models.questions.Answer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnswetMapperTest {

    @Test
    void mapAnswerDtoToAnswer(){
        AnswerDto answerDto = new AnswerDto("test question", true);

        Answer answer = AnswerMapper.map(answerDto);

        assertThat(answer.getAnswerContent()).isEqualTo(answerDto.getAnswerContent());
        assertThat(answer.isCorrect()).isEqualTo(answerDto.isCorrect());

    }
}
