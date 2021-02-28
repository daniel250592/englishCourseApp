package sda.ispeak.prework.models.mappers;


import sda.ispeak.prework.models.dtos.AnswerDto;
import sda.ispeak.prework.models.questions.Answer;

public class AnswerMapper {

    public static Answer map(AnswerDto answerDto){
        return new Answer(answerDto.getAnswerContent(), answerDto.isCorrect());
    }
}
