package sda.ispeak.prework.controllers;



import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.AnswerDto;
import sda.ispeak.prework.models.forms.FourAnswersForm;
import sda.ispeak.prework.models.questions.Answer;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.services.AnswerService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/add-new-answer")
    public Answer addAnswer(@RequestBody AnswerDto answerDto) {
        return answerService.save(answerDto);
    }

    @GetMapping("/find-answer-by-id/{id}")
    public Answer findAnswerById(@PathVariable long id){
       return answerService.findAnswerById(id);
    }

    @GetMapping("/get-all-answers")
    public List<Answer> getAllAnswers(){
        return answerService.getAllAnswers();
    }

    @PutMapping("/update-answer-content/{id}")
    public Answer updateAnswerContent(@RequestBody AnswerDto answerDto, @PathVariable long id){
      return   answerService.updateAnswerContent(id,answerDto);
    }

    @PutMapping("/update-answer-corectness/{id}")
    public Answer updateAnswerCorrectness(@RequestBody AnswerDto answerDto, @PathVariable long id){
        return   answerService.updateAnswerCorrectness(id,answerDto);
    }

    @PostMapping("/add-four-answers-to-question/{id}")
    public Question addFourAnswers(@RequestBody FourAnswersForm fourAnswersForm, @PathVariable long id){
        return answerService.connectAnswersToQuestion(id,fourAnswersForm);
    }

}
