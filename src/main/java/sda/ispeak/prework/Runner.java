package sda.ispeak.prework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sda.ispeak.prework.models.dtos.TopicDto;
import sda.ispeak.prework.models.mappers.TopicMapper;
import sda.ispeak.prework.models.dtos.user.UserDto;
import sda.ispeak.prework.models.questions.Answer;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.models.questions.QuestionSubject;
import sda.ispeak.prework.models.topic.Quiz;
import sda.ispeak.prework.models.topic.Topic;
import sda.ispeak.prework.models.users.User;
import sda.ispeak.prework.repositories.AnswerRepository;
import sda.ispeak.prework.repositories.QuestionRepository;
import sda.ispeak.prework.repositories.TopicRepository;
import sda.ispeak.prework.repositories.UserRepository;
import sda.ispeak.prework.services.TopicService;
import sda.ispeak.prework.services.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class Runner implements CommandLineRunner {


    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) {

        try {
            User user = new User();

            user.setEmail("test@example.com");
            user.setUserName("example");
            user.setPassword("example");

            UserDto userDto = new UserDto();

            userDto.setUserName(user.getUserName());
            userDto.setEmail(user.getEmail());
            userDto.setPassword(user.getPassword());
            userDto.setConfirmedPassword(user.getPassword());

            userService.save(userDto);

            Answer answerA = new Answer("Good morning", true);
            Answer answerB = new Answer("Guten Dag", false);

            Answer save = answerRepository.save(answerA);
            Answer answer = answerRepository.save(answerB);


            Set<Answer> answers = new HashSet<>();
            answers.add(save);
            answers.add(answer);
            Question question = new Question("PresentSimple", "Jak jest dzien dobry po angielsku?");


            questionRepository.save(question);

            Set<Answer> answers1 = question.getAnswers();

            QuestionSubject futureSimple = QuestionSubject.valueOf("FutureSimple");


        } catch (Exception e) {
            log.error("Nie inicjuje bazy - problem ", e);
        }

    }
}
