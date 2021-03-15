package sda.ispeak.prework.models.mappers;


import sda.ispeak.prework.models.dtos.question.NewQuestionDto;
import sda.ispeak.prework.models.dtos.question.QuestionProfileDto;
import sda.ispeak.prework.models.entities.questions.Question;

public class QuestionMapper {
    public static Question map(NewQuestionDto newQuestionDto) {
        return Question.builder()
                .id(newQuestionDto.getId())
                .question(newQuestionDto.getQuestion())
                .firstAnswerContent(newQuestionDto.getFirstAnswerContent())
                .secondAnswerContent(newQuestionDto.getSecondAnswerContent())
                .thirdAnswerContent(newQuestionDto.getThirdAnswerContent())
                .fourthAnswerContent(newQuestionDto.getFourthAnswerContent())
                .firstCorrect(newQuestionDto.isFirstCorrect())
                .secondCorrect(newQuestionDto.isSecondCorrect())
                .thirdCorrect(newQuestionDto.isThirdCorrect())
                .fourthCorrect(newQuestionDto.isFourthCorrect())
                .build();
    }

    public static QuestionProfileDto map(Question question) {
        return QuestionProfileDto.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .firstAnswerContent(question.getFirstAnswerContent())
                .secondAnswerContent(question.getSecondAnswerContent())
                .thirdAnswerContent(question.getThirdAnswerContent())
                .fourthAnswerContent(question.getFourthAnswerContent())
                .firstCorrect(question.isFirstCorrect())
                .secondCorrect(question.isSecondCorrect())
                .thirdCorrect(question.isThirdCorrect())
                .fourthCorrect(question.isFourthCorrect())
                .build();
    }
}
