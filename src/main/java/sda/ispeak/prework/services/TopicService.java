package sda.ispeak.prework.services;

import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.topic.NewTopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicProfile;
import sda.ispeak.prework.models.dtos.topic.TopicToListDto;
import sda.ispeak.prework.models.exceptions.NoSuchTopicExeption;
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


    public List<TopicToListDto> getAllTopics() {
        return topicRepository.findAll().stream()
                .sorted(Comparator.comparing(Topic::getId)).map(TopicMapper::map)
                .collect(Collectors.toList());
    }

    public String getContentFromTopic(long id) {

        return topicRepository.findById(id).orElseThrow(() -> new NoSuchTopicExeption("Brak takiego tematu"))
                .getContent();
    }

    public Topic save(NewTopicDto newTopicDto) {
        Topic topic = TopicMapper.map(newTopicDto);
        return topicRepository.save(topic);
    }

    public Topic updateTopicName(long id, TopicProfile topicProfile) {
        Topic topic = topicRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchTopicExeption("Brak takiego tematu"));
        topic.setName(topicProfile.getName());
        return topic;
    }

    public Topic updateTopicContent(long id, TopicProfile topicProfile) {
        Topic topic = topicRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchTopicExeption("Brak takiego tematu"));
        topic.setContent(topicProfile.getContent());
        return topic;
    }
}
