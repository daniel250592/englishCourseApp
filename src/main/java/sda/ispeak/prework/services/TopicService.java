package sda.ispeak.prework.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.topic.NewTopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicToListDto;
import sda.ispeak.prework.models.entities.topic.Topic;
import sda.ispeak.prework.models.exceptions.NoSuchTopicExeption;
import sda.ispeak.prework.models.mappers.TopicMapper;
import sda.ispeak.prework.repositories.TopicRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final QuizService quizService;

    public TopicService(TopicRepository topicRepository, @Lazy QuizService quizService) {
        this.topicRepository = topicRepository;
        this.quizService = quizService;
    }


    public List<TopicToListDto> getAllTopics() {
        return topicRepository.findAll().stream()
                .sorted(Comparator.comparing(Topic::getId)).map(TopicMapper::map)
                .collect(Collectors.toList());
    }

    public String getContentFromTopic(long id) {
        return findById(id).getContent();
    }

    public TopicDto save(NewTopicDto newTopicDto) {
        Topic topic = TopicMapper.map(newTopicDto);
        topic = topicRepository.save(topic);
        quizService.createNewQuizToTopic(topic.getId());
        return TopicMapper.mapToDto(topic);
    }

    public TopicDto updateTopic(long id, NewTopicDto topicDto) {
        Topic topic = findById(id);
        topic.setName(topicDto.getName());
        topic.setContent(topicDto.getContent());
        topicRepository.save(topic);
        return TopicMapper.mapToDto(topic);
    }

    public Topic findById(long id) {
        return topicRepository.findById(id).orElseThrow(() -> new NoSuchTopicExeption("Brak Tematu o podanym ID"));
    }

}
