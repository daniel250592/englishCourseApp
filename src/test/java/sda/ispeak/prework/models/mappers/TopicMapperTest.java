package sda.ispeak.prework.models.mappers;

import org.junit.jupiter.api.Test;
import sda.ispeak.prework.models.dtos.topic.NewTopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicToListDto;
import sda.ispeak.prework.models.entities.topic.Topic;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TopicMapperTest {

    @Test
    void shoudMapTopicToTopicToListDto() {

        Topic topic = Topic.builder()
                .id(1L)
                .name("Example name")
                .build();

        TopicToListDto topicToListDto = TopicMapper.map(topic);

        assertThat(topicToListDto.getId()).isEqualTo(topic.getId());
        assertThat(topicToListDto.getName()).isEqualTo(topic.getName());
    }

    @Test
    void shouldMapToTopicFromNewTopicDto() {

        NewTopicDto newTopicDto = NewTopicDto.builder()
                .id(2L)
                .name("Example name")
                .content("test content")
                .build();

        Topic topic = TopicMapper.map(newTopicDto);

        assertThat(topic.getId()).isEqualTo(newTopicDto.getId());
        assertThat(topic.getName()).isEqualTo(newTopicDto.getName());
        assertThat(topic.getContent()).isEqualTo(newTopicDto.getContent());
    }

    @Test
    void shouldMapTopicProfileToTopic() {

        TopicDto topicDto = TopicDto.builder()
                .id(3L)
                .name("Example name")
                .content("example content")
                .build();

        Topic topic = TopicMapper.map(topicDto);

        assertThat(topic.getId()).isEqualTo(topicDto.getId());
        assertThat(topic.getName()).isEqualTo(topicDto.getName());
        assertThat(topic.getContent()).isEqualTo(topicDto.getContent());
    }
}
