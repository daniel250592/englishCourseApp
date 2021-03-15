package sda.ispeak.prework.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    //TODO w momencie jak Ola bedzie tworzyła nowy topic to bede tworzył nowy quiz a pytania będą dodawane do odpowiedniego quizu przez admina

    @GetMapping("/get-content/{id}")
    public String getContentFromTopic(@PathVariable long id) {
        return service.getContentFromTopic(id);
    }

}
