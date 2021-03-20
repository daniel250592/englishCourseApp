package sda.ispeak.prework.models.dtos.question;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionProfileWithoutCorrectness {

    private long id;

    private String question;

    private String firstAnswerContent;
    private String secondAnswerContent;
    private String thirdAnswerContent;
    private String fourthAnswerContent;

    private int quizScore;
}
