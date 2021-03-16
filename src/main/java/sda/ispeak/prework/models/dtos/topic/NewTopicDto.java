package sda.ispeak.prework.models.dtos.topic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@ToString
@AllArgsConstructor
public class NewTopicDto {

    @NotNull(message = "Wpisz id")
    @NotBlank(message = "Wpisz id")
    private long id;

    @NotNull(message = "Nazwij temat")
    @NotBlank(message = "Nazwij temat")
    @Size(min = 2, max = 100, message = "Temat musi zawierać minimalnie 2 znaki, maksymalnie 50 znaków")
    private String name;

    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
