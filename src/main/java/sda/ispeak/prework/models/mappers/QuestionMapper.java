package sda.ispeak.prework.models.mappers;


import sda.ispeak.prework.models.dtos.QuestionDto;
import sda.ispeak.prework.models.questions.Question;

public class QuestionMapper {

    public static Question map(QuestionDto questionDto){
        return new Question(questionDto.getSubject().toString(), questionDto.getContent());
    }
}
