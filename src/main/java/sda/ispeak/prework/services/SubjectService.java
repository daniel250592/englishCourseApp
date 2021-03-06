package sda.ispeak.prework.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {


    public List<String> getAllSubjects(){
        return List.of("Simple Past", "Present Perfect", "Past Perfect");
    }
}
