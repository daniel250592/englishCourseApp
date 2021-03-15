package sda.ispeak.prework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.ispeak.prework.services.QuizService;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("{topic}/questions-list")
    public List<Long> getQuestionsIdsFromGivenTopic(String topic) {
        return quizService.getQuestionsIdsFromGivenTopic(topic);
    }


}