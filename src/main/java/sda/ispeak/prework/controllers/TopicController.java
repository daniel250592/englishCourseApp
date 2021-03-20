package sda.ispeak.prework.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.ispeak.prework.models.dtos.topic.TopicProfile;
import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.topic.NewTopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicToListDto;
import sda.ispeak.prework.models.entities.topic.Topic;
import sda.ispeak.prework.services.TopicService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService service;

    @PostMapping("/add-new-topic")
    public Topic addTopic(@RequestBody NewTopicDto newTopicDto) {
        return service.save(newTopicDto);
    }

    @PutMapping("/update-topic-name/{id}")
    public Topic updateTopicName(@RequestBody TopicProfile topicProfile, @PathVariable long id) {
        return service.updateTopicName(id, topicProfile);
    }

    @PutMapping("/update-topic-content/{id}")
    public Topic updateTopicContent(@RequestBody TopicProfile topicProfile, @PathVariable long id) {
        return service.updateTopicContent(id, topicProfile);
    }

    @GetMapping()
    public List<TopicToListDto> getAllTopics() {

        return service.getAllTopics();
    }

    @GetMapping("/content/{id}")
    public String getContentFromTopic(@PathVariable long id) {

        return service.getContentFromTopic(id);
    }
}
