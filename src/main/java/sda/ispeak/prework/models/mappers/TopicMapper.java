package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.TopicProfile;
import sda.ispeak.prework.models.topic.Topic;


public class TopicMapper {

    public static TopicProfile map(Topic topic) {

        return TopicProfile.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }

}
