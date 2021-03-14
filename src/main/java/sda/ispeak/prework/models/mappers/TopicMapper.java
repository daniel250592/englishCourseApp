package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.TopicDto;
import sda.ispeak.prework.models.topic.Topic;


public class TopicMapper {

    public static TopicDto mapToTopicList(Topic topic) {

        return TopicDto.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }

}
