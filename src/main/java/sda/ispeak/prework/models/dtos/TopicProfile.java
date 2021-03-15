package sda.ispeak.prework.models.dtos;

import com.sun.istack.NotNull;
import lombok.Builder;

import javax.validation.constraints.Size;

@Builder
public class TopicProfile {


    private long id;

    @Size(min = 2, max = 100, message = "Temat musi zawierać minimalnie 2 znaki, maksymalnie 50 znaków")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
