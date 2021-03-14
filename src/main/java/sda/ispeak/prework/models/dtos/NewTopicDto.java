package sda.ispeak.prework.models.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewTopicDto {

    @NotNull
    private long id;

    @NotNull
    @Size(min = 2, max = 100, message = "Temat musi zawierać minimalnie 2 znaki, maksymalnie 50 znaków")
    private String name;

    @NotNull
    @Size(min = 2, max = 300, message = "Temat musi zawierać minimalnie 2 znaki, maksymalnie 300 znaków")
    private String content;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
