package sda.ispeak.prework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.services.TopicService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final TopicService topicService;

    public QuizController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("{topic}/question/{questionId}")
    public Question getQuestionWithGivenIdFromQuizWithGivenId(@PathVariable String topic, @PathVariable long questionId){
        return topicService.getQuestionWithGivenIdFromQuizWithGivenId(topic,questionId);

    }
}
