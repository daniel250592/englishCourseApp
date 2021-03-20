package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.topic.NewTopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicProfile;
import sda.ispeak.prework.models.dtos.topic.TopicToListDto;
import sda.ispeak.prework.models.entities.topic.Topic;


public class TopicMapper {

    public static TopicToListDto map(Topic topic) {

        return TopicToListDto.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }

    public static Topic map(NewTopicDto newTopicDto) {

        return Topic.builder()
                .id(newTopicDto.getId())
                .name(newTopicDto.getName())
                .content(newTopicDto.getContent())
                .build();
    }

    public static Topic map(TopicProfile topicProfile) {

        return Topic.builder()
                .id(topicProfile.getId())
                .name(topicProfile.getName())
                .content(topicProfile.getContent())
                .build();
    }
}
