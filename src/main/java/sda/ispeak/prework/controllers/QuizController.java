package sda.ispeak.prework.controllers;

import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.question.AnswerDto;
import sda.ispeak.prework.models.dtos.question.QuestionProfileWithoutCorrectness;
import sda.ispeak.prework.models.dtos.userPoints.UserPointsProfile;
import sda.ispeak.prework.models.entities.userPoints.UserPoints;
import sda.ispeak.prework.services.QuizService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/{topic}/questions-list")
    public List<Long> getQuestionsIdsFromGivenTopic(String topic) {
        return quizService.getQuestionsIdsFromGivenTopic(topic);
    }

    @GetMapping("/question/{id}")
    public QuestionProfileWithoutCorrectness getQuestion(@PathVariable long id) {
        return quizService.getQuestionById(id);
    }

    @PostMapping("/check")
    public boolean checkAnswerCorrectness(@RequestBody @Valid AnswerDto answerDto) {
        return quizService.checkAnswerCorrectness(answerDto);
    }

    @PostMapping("/{quizId}/add{points}user{userId}")
    public UserPointsProfile addPointsToUser(@PathVariable long quizId, @PathVariable int points, @PathVariable long userId) {
        return quizService.addPointsToUser(quizId, points, userId);
    }


}