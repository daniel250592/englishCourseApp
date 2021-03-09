package sda.ispeak.prework.models.mappers;

import lombok.Builder;
import sda.ispeak.prework.models.dtos.QuestionDto;
import sda.ispeak.prework.models.dtos.TopicDto;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.models.topic.Topic;


public class TopicMapper {
    public static Topic map(TopicDto topicDto){
        return new Topic((topicDto.getId()), topicDto.getName());
    }

    public static TopicDto topicMapper(Topic topic) {

        return TopicDto.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }
}
