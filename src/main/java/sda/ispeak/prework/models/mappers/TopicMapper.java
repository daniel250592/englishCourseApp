package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.NewTopicDto;
import sda.ispeak.prework.models.dtos.TopicProfile;
import sda.ispeak.prework.models.topic.Topic;


public class TopicMapper {

    public static Topic map(NewTopicDto newTopicDto) {
        return Topic.builder()
                .id(newTopicDto.getId())
                .content(newTopicDto.getContent())
                .name(newTopicDto.getName())
                .build();
    }

    public static TopicProfile map(Topic topic) {
        return TopicProfile.builder()
                .id(topic.getId())
                .content(topic.getContent())
                .name(topic.getName())
                .build();
    }

}
