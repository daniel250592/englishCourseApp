package sda.ispeak.prework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @GetMapping()
    public List<String> getAllQuestions() {
        return List.of("Simple Past", "Present Perfect", "Past Perfect");
    }
}
