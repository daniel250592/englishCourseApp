package sda.ispeak.prework.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sda.ispeak.prework.models.dtos.topic.TopicProfile;
import sda.ispeak.prework.models.topic.Topic;
import sda.ispeak.prework.repositories.TopicRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TopicServiceTest{

    @InjectMocks
    private TopicService sut;

    @Mock
    private TopicRepository topicRepository;


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

        List<TopicProfile> result = sut.getAllTopics();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getId()).isEqualTo(1L);
    }
}
