package sda.ispeak.prework.models.dtos.topic;

import lombok.Builder;

@Builder
public class TopicToListDto {


    private long id;

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
