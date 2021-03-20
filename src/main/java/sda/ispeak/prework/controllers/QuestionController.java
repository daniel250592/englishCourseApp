package sda.ispeak.prework.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sda.ispeak.prework.models.dtos.question.NewQuestionDto;
import sda.ispeak.prework.models.dtos.question.QuestionProfileDto;
import sda.ispeak.prework.models.entities.questions.Question;
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

    @PostMapping("/add-new-question")
    public QuestionProfileDto addQuestion(@RequestBody @Valid NewQuestionDto newQuestionDto) {
        return questionService.save(newQuestionDto);
    }

    @GetMapping("/get-all-questions")
    public List<QuestionProfileDto> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("question/{id}")
    public QuestionProfileDto getQuestionById(@PathVariable long id) {
        return questionService.getQuestionProfileById(id);
    }


}
