package sda.ispeak.prework.models.dtos;

import com.sun.istack.NotNull;
import lombok.ToString;

import javax.validation.constraints.Size;

@ToString
public class QuestionDto {

    private long id;

    @NotNull
    @Size(min = 15, max = 250, message = "Twoje pytanie nie spełnia standardów")
    private String content;
    private String questionSubject;

    private String firstAnswerContent;
    private String secondAnswerContent;
    private String thirdAnswerContent;
    private String fourthAnswerContent;


    private boolean firstCorrect = false;
    private boolean secondCorrect = false;
    private boolean thirdCorrect = false;
    private boolean fourthCorrect = false;


    public QuestionDto() {
    }

}
