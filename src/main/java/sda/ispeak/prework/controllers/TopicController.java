package sda.ispeak.prework.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.TopicToListDto;
import sda.ispeak.prework.services.TopicService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService service;


    @GetMapping()
    public List<TopicToListDto> getAllTopics() {

        return service.getAllTopics();
    }
}
