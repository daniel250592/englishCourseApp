package sda.ispeak.prework.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;
import sda.ispeak.prework.models.dtos.topic.NewTopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicToListDto;
import sda.ispeak.prework.models.entities.topic.Topic;
import sda.ispeak.prework.repositories.TopicRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TopicServiceTest{

    @InjectMocks
    private TopicService topicService;

    @Mock
    private TopicRepository topicRepository;

    @Mock
    private QuizService quizService;

    @Test
    void shouldFetchTopicsAndCheckOrder() {
        when(topicRepository.findAll())
                .thenReturn(List.of(
                        Topic.builder()
                                .id(3L)
                                .build(),
                        Topic.builder()
                                .id(1L)
                                .build()));
        List<TopicToListDto> result = topicService.getAllTopics();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getId()).isEqualTo(1L);
    }
    @Test
    void shouldFindTopicById() {
        when(topicRepository.findById(2L)).thenReturn(Optional.of(Topic.builder()
                .id(2L)
                .name("name")
                .content("context")
                .build()));
        Topic topic = topicService.findById(2L);
        assertThat(topic.getName()).isEqualTo("name");
        assertThat(topic.getContent()).isEqualTo("context");
    }
    @Test
    void shouldUpdateTopic() {
        when(topicRepository.findById(2L)).thenReturn(Optional.of(Topic.builder()
                .id(2L)
                .name("name")
                .content("content")
                .build()));
        Topic topic = topicService.findById(2L);
        topic.setName("new name");
        topic.setContent("new content");
        topicRepository.save(topic);
        assertThat(topic.getName()).isEqualTo("new name");
        assertThat(topic.getContent()).isEqualTo("new content");
    }

    @Test
    void shouldSaveTopic() {
        NewTopicDto newTopicDto = NewTopicDto.builder()
                .id(1L)
                .name("topic name")
                .content("topic content")
                .build();

        when(topicRepository.save(any()))
                .thenReturn(Topic.builder()
                .id(1L)
                .name("topic name")
                .content("topic content")
                .build());

        TopicDto topicDto = topicService.save(newTopicDto);
        assertThat(topicDto.getName()).isEqualTo("topic name");
        assertThat(topicDto.getContent()).isEqualTo("topic content");
    }
}
