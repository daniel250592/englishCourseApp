package sda.ispeak.prework.models.dtos.question;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionProfileDto {

    private long id;

    private String question;

    private String firstAnswerContent;
    private String secondAnswerContent;
    private String thirdAnswerContent;
    private String fourthAnswerContent;

    private boolean firstCorrect = false;
    private boolean secondCorrect = false;
    private boolean thirdCorrect = false;
    private boolean fourthCorrect = false;

}
