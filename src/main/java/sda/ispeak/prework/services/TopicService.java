package sda.ispeak.prework.services;

import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.TopicDto;
import sda.ispeak.prework.models.mappers.TopicMapper;
import sda.ispeak.prework.models.topic.Topic;
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


    public List<TopicDto> getAllTopics(){
        return topicRepository.findAll().stream()
                .sorted(Comparator.comparing(Topic::getId)).map(TopicMapper::mapToTopicList)
                .collect(Collectors.toList());
    }
}