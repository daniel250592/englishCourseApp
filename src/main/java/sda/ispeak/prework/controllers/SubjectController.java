package sda.ispeak.prework.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.ispeak.prework.services.SubjectService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService service;

    @GetMapping()
    public List<String> getAllSubjects() {
        return service.getAllSubjects();
    }
}
