package sda.ispeak.prework.services;

import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.topic.Topic;
import sda.ispeak.prework.repositories.TopicRepository;

import javax.security.auth.Subject;
import java.util.List;

@Service
public class TopicService {

    private TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics(){

        return topicRepository.findAll();
    }
}
