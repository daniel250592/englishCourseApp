package sda.ispeak.prework.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.QuestionDto;
import sda.ispeak.prework.models.dtos.TopicDto;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.models.topic.Topic;
import sda.ispeak.prework.services.TopicService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/subjects")
public class TopicController {

    private final TopicService service;


    @GetMapping()
    public List<TopicDto> getAllTopics() {

        return service.getAllTopics();
    }
}
