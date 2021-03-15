package sda.ispeak.prework.controllers;


import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.NewQuestionDto;
import sda.ispeak.prework.models.dtos.QuestionProfileDto;
import sda.ispeak.prework.models.questions.Question;
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


}
