package sda.ispeak.prework.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.topic.NewTopicDto;
import sda.ispeak.prework.models.dtos.topic.TopicProfile;
import sda.ispeak.prework.services.TopicService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService service;

    @GetMapping()
    public List<TopicProfile> getAllTopics() {

        return service.getAllTopics();
    }

    @GetMapping("/get-content/{id}")
    public String getContentFromTopic(@PathVariable long id) {
        return service.getContentFromTopic(id);
    }

    @PostMapping("/new-topic")
    public TopicProfile addNewTopic(@RequestBody NewTopicDto newTopicDto){
        return service.addNewTopic(newTopicDto);
    }

}
