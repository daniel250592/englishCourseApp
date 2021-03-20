package sda.ispeak.prework.models.dtos.question;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {

    @NotNull
    @NotBlank
    private String chosenAnswer;

    @Min(value = 0)
    private long questionId;

    private int quizScore;
}


