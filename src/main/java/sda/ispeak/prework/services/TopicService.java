package sda.ispeak.prework.services;

import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.topic.TopicProfile;
import sda.ispeak.prework.models.entities.topic.Topic;
import sda.ispeak.prework.models.mappers.TopicMapper;
import sda.ispeak.prework.repositories.TopicRepository;

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

    public String getContentFromTopic(long id) {
        return topicRepository.findById(id).orElseThrow().getContent();
    }

    public Topic getTopicByName(String name) {
        return topicRepository.findTopicByName(name).orElseThrow();
        //TODO dodać własny wyjątek
    }
}
