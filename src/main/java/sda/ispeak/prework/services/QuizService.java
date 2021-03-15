package sda.ispeak.prework.services;

import org.springframework.stereotype.Service;
import sda.ispeak.prework.repositories.QuizRepository;

import java.util.List;

@Service
public class QuizService {

    private final QuestionService questionService;
    private final TopicService topicService;
    private final QuizRepository quizRepository;


    public QuizService(QuestionService questionService, TopicService topicService, QuizRepository quizRepository) {
        this.questionService = questionService;
        this.topicService = topicService;
        this.quizRepository = quizRepository;
    }

    private List<Long> getQuestionsIdsFromGivenQuiz(long quizId) {
        return quizRepository.findQuestionsByQuizId(quizId);
    }

    public List<Long> getQuestionsIdsFromGivenTopic(String topic) {
        long id = topicService.getTopicByName(topic).getId();
        return getQuestionsIdsFromGivenQuiz(id);
    }
}
