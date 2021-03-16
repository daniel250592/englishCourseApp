package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.topic.NewTopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicProfile;
import sda.ispeak.prework.models.entities.topic.Topic;


public class TopicMapper {

    public static TopicProfile map(Topic topic) {
        return TopicProfile.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }

    public static Topic map(NewTopicDto newTopicDto) {
        return Topic.builder()
                .name(newTopicDto.getName())
                .build();
    }
}
