package sda.ispeak.prework.models.mappers;

import org.junit.jupiter.api.Test;
import sda.ispeak.prework.models.dtos.QuestionDto;
import sda.ispeak.prework.models.questions.Question;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuestionMapperTest {

    @Test
    void shouldMapQuestionDtoToQuestion(){
        QuestionDto questionDto = new QuestionDto("PastSimple", "test content");

        Question question = QuestionMapper.map(questionDto);

        assertThat(question.getSubject()).isEqualTo(questionDto.getSubject());
        assertThat(question.getContent()).isEqualTo(questionDto.getContent());
    }
}
