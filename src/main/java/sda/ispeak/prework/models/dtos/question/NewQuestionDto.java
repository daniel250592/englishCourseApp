package sda.ispeak.prework.models.dtos.question;

import lombok.*;
import sda.ispeak.prework.models.validations.question.DifferentQuestionsValidator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DifferentQuestionsValidator
public class NewQuestionDto {

    @Min(message = "Wpisz id", value = 0L)
    private long id;

    @NotBlank(message = "Wpisz pytanie")
    @NotNull(message = "Wpisz pytanie")
    @Size(min = 10, max = 200, message = "Twoje pytanie nie spełnia standardów")
    private String question;

    @NotBlank(message = "Wpisz odpowiedź pierwszą")
    @NotNull(message = "Wpisz odpowiedź pierwszą")
    @Size(min = 1, max = 100, message = "Odpowiedź pierwsza nie spełnia standardów")
    private String firstAnswerContent;
    @NotBlank(message = "Wpisz odpowiedź drugą")
    @NotNull(message = "Wpisz odpowiedź drugą")
    @Size(min = 1, max = 100, message = "Odpowiedź druga nie spełnia standardów")
    private String secondAnswerContent;
    @NotBlank(message = "Wpisz odpowiedź trzecią")
    @NotNull(message = "Wpisz odpowiedź trzecią")
    @Size(min = 1, max = 100, message = "Odpowiedź trzecia nie spełnia standardów")
    private String thirdAnswerContent;
    @NotBlank(message = "Wpisz odpowiedź czwartą")
    @NotNull(message = "Wpisz odpowiedź czwartą")
    @Size(min = 1, max = 100, message = "Odpowiedź czwarta nie spełnia standardów")
    private String fourthAnswerContent;

    private boolean firstCorrect = false;
    private boolean secondCorrect = false;
    private boolean thirdCorrect = false;
    private boolean fourthCorrect = false;

}
