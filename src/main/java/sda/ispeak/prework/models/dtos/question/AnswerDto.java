package sda.ispeak.prework.models.dtos.question;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@ToString
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AnswerDto {

    @NotNull
    @NotBlank
    private String chosenAnswer;

    @Min(value = 0)
    private long questionId;
}
