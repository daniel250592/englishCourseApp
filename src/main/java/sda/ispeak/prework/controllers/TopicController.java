package sda.ispeak.prework.controllers;

import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.NewTopicDto;
import sda.ispeak.prework.models.dtos.TopicProfile;
import sda.ispeak.prework.services.TopicService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping()
    public TopicProfile addNewTopic(@RequestBody @Valid NewTopicDto newTopicDto) {
        return topicService.addNewTopic(newTopicDto);
    }

    @GetMapping()
    public List<TopicProfile> getAllTopics() {
        return topicService.getAllTopics();
    }
}
