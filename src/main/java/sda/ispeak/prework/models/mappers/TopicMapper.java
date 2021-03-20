package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.topic.NewTopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicToListDto;
import sda.ispeak.prework.models.entities.topic.Topic;


public class TopicMapper {

    private TopicMapper() {}

    public static TopicToListDto map(Topic topic) {

        return TopicToListDto.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }

     public static TopicDto mapToDto(Topic topic) {

        return TopicDto.builder()
                .id(topic.getId())
                .name(topic.getName())
                .content(topic.getContent())
                .build();
    }

    public static Topic map(NewTopicDto newTopicDto) {

        return Topic.builder()
                .id(newTopicDto.getId())
                .name(newTopicDto.getName())
                .content(newTopicDto.getContent())
                .build();
    }

    public static Topic map(TopicDto topicDto) {

        return Topic.builder()
                .id(topicDto.getId())
                .name(topicDto.getName())
                .content(topicDto.getContent())
                .build();
    }
}
