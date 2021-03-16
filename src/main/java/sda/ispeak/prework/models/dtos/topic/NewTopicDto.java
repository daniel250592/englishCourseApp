package sda.ispeak.prework.models.dtos.topic;

import lombok.*;

import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewTopicDto {

    @Size(min = 2, max = 100, message = "Temat musi zawierać minimalnie 2 znaki, maksymalnie 50 znaków")
    private String name;
}
