package sda.ispeak.prework.models.entities.questions;

import lombok.*;
import sda.ispeak.prework.models.validations.answer.CorrectAnswerValidator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue
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
