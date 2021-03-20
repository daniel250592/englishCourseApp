package sda.ispeak.prework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.ispeak.prework.models.dtos.question.AnswerDto;
import sda.ispeak.prework.models.dtos.question.QuestionProfileWithoutCorrectness;
import sda.ispeak.prework.models.dtos.userPoints.UserPointsProfile;
import sda.ispeak.prework.services.QuizService;

import javax.validation.Valid;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/{topicId}/question/{userId}")
    public QuestionProfileWithoutCorrectness getQuestionsIdsFromGivenTopic(
            @PathVariable long topicId,
            @RequestBody(required = false) AnswerDto answerDto,
            @PathVariable long userId) {
        return quizService.getQuestionFromGivenQuizAndCheckCorrectness(topicId, answerDto, userId);
    }
}