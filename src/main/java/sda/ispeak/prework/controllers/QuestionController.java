package sda.ispeak.prework.controllers;


import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.QuestionDto;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.services.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/admin/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add-new-question")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.save(question);
    }

    @GetMapping("/get-all-questions")
    public List<Question> getAllQuestions() {
       return questionService.getAllQuestions();

    }


}
