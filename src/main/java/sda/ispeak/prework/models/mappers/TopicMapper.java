package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.TopicToListDto;
import sda.ispeak.prework.models.topic.Topic;


public class TopicMapper {

    public static TopicToListDto mapToTopicList(Topic topic) {

        return TopicToListDto.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }

}
