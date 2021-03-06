package sda.ispeak.prework.controllers;


import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.ispeak.prework.models.dtos.question.NewQuestionDto;
import sda.ispeak.prework.models.dtos.question.QuestionProfileDto;
import sda.ispeak.prework.services.QuestionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping()
    public QuestionProfileDto addQuestion(@RequestBody @Valid NewQuestionDto newQuestionDto) {
        return questionService.save(newQuestionDto);
    }

    @PostMapping("/{questionId}/question-to-quiz/{quizId}")
    public List<QuestionProfileDto> assignQuestionToQuiz(@PathVariable long questionId, @PathVariable long quizId){
        return questionService.assignQuestionToQuiz(questionId,quizId);
    }

//    @PutMapping("/{questionId}")
//    public QuestionProfileDto updateQuestion(@PathVariable long questionId, @RequestBody @Valid NewQuestionDto newQuestionDto) {
//        return questionService.updateQuestion(questionId,newQuestionDto);
//    }

    @DeleteMapping("/{questionId}")
    public boolean deleteQuestion(@PathVariable long questionId) {
        return questionService.delete(questionId);
    }

}
