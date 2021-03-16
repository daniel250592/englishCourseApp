package sda.ispeak.prework.models.dtos.question;

import lombok.*;

@ToString
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class QuestionProfileWithoutCorrectness {

    private long id;

    private String question;

    private String firstAnswerContent;
    private String secondAnswerContent;
    private String thirdAnswerContent;
    private String fourthAnswerContent;
}
