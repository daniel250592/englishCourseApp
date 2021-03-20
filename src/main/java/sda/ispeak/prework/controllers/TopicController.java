package sda.ispeak.prework.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.ispeak.prework.models.dtos.topic.NewTopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicToListDto;
import sda.ispeak.prework.services.TopicService;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicService service;

    @PostMapping()
    public TopicDto addTopic(@Valid @RequestBody NewTopicDto topic) {
        return service.save(topic);
    }

    @PutMapping()
    public TopicDto updateTopicName(@Valid @RequestBody NewTopicDto topic) {
        return service.updateTopic(topic.getId(), topic);
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
