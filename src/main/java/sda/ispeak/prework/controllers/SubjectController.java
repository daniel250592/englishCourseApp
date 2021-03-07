package sda.ispeak.prework.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.ispeak.prework.models.topic.Topic;
import sda.ispeak.prework.services.TopicService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final TopicService service;

    @GetMapping("/get")
    public List<Topic> getAllTopics() {

        return service.getAllTopics();
    }
}
