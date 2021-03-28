package sda.ispeak.prework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sda.ispeak.prework.models.emails.EmailSender;
import sda.ispeak.prework.repositories.QuestionRepository;
import sda.ispeak.prework.repositories.UserRepository;
import sda.ispeak.prework.services.QuestionService;
import sda.ispeak.prework.services.QuizService;
import sda.ispeak.prework.services.UserService;

@Component
@Slf4j
public class Runner implements CommandLineRunner {


    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuizService quizService;

    @Autowired
    QuestionService questionService;


    @Override
    public void run(String... args) {


    }
}
