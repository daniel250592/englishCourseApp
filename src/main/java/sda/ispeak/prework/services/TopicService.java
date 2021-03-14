package sda.ispeak.prework.services;

import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.NewTopicDto;
import sda.ispeak.prework.models.dtos.TopicProfile;
import sda.ispeak.prework.models.mappers.TopicMapper;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.models.topic.Topic;
import sda.ispeak.prework.repositories.TopicRepository;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    public List<TopicProfile> getAllTopics() {
        return topicRepository.findAll().stream()
                .sorted(Comparator.comparing(Topic::getId)).map(TopicMapper::map)
                .collect(Collectors.toList());
    }

    public TopicProfile addNewTopic(NewTopicDto newTopicDto) {
        Topic topic = topicRepository.save(TopicMapper.map(newTopicDto));
        return TopicMapper.map(topic);
    }

    public Question getQuestionWithGivenIdFromQuizWithGivenId(String topic, long questionId) {
        System.out.println(topicRepository.findQuestion());
        return null;

    }
}
