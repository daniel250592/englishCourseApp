package sda.ispeak.prework.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.question.AnswerDto;
import sda.ispeak.prework.models.dtos.question.QuestionProfileDto;
import sda.ispeak.prework.models.dtos.question.QuestionProfileWithoutCorrectness;
import sda.ispeak.prework.models.dtos.userPoints.UserPointsProfile;
import sda.ispeak.prework.models.entities.questions.Question;
import sda.ispeak.prework.models.entities.quiz.Quiz;
import sda.ispeak.prework.models.entities.userPoints.UserPoints;
import sda.ispeak.prework.models.mappers.QuestionMapper;
import sda.ispeak.prework.models.mappers.UserPointsMapper;
import sda.ispeak.prework.models.utils.QuestionIdManager;
import sda.ispeak.prework.repositories.QuizRepository;
import sda.ispeak.prework.repositories.UserPointsRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuizService {

    private final QuestionService questionService;
    private final TopicService topicService;
    private final QuizRepository quizRepository;
    private final UserPointsRepository userPointsRepository;
    private final UserService userService;
    private final QuestionIdManager questionIdManager;


    public QuizService(QuestionService questionService, @Lazy TopicService topicService, QuizRepository quizRepository, UserPointsRepository userPointsRepository, UserService userService, QuestionIdManager questionIdManager) {
        this.questionService = questionService;
        this.topicService = topicService;
        this.quizRepository = quizRepository;
        this.userPointsRepository = userPointsRepository;
        this.userService = userService;
        this.questionIdManager = questionIdManager;
    }

    private List<Long> getQuestionsIdsFromGivenQuiz(long quizId) {
        return quizRepository.findQuestionsByQuizId(quizId);
    }

    private List<Long> getQuestionsIdsFromGivenTopic(String topic) {
        long id = topicService.getTopicByName(topic).getId();
        return getQuestionsIdsFromGivenQuiz(id);
    }

    public QuestionProfileDto getQuestionFromGivenQuiz(String topic) {
        if (questionIdManager.isEmpty()) {
            List<Long> questionsIdsFromGivenTopic = getQuestionsIdsFromGivenTopic(topic);
            questionIdManager.addValuesToQueue(questionsIdsFromGivenTopic);
        }
        if (questionIdManager.peekNextId() != null) {
            return  QuestionMapper.map(questionService.getQuestionById(questionIdManager.pollNextId()));
        } else {
            throw new NoSuchElementException("Quiz zakończony");
            //TODO zrobić swój wyjątek
        }

    }


    public QuestionProfileWithoutCorrectness getQuestionById(long id) {
        return QuestionMapper.mapAndReturnQuestionProfileWithoutCorrectness(questionService.getQuestionById(id));
    }

    public boolean checkAnswerCorrectness(AnswerDto answerDto) {
        Question questionById = questionService.getQuestionById(answerDto.getQuestionId());
        String correctAnswer = getCorrectAnswer(questionById);
        return answerDto.getChosenAnswer().equals(correctAnswer);
    }

    private String getCorrectAnswer(Question question) {
        if (question.isFirstCorrect()) {
            return question.getFirstAnswerContent();
        } else if (question.isSecondCorrect()) {
            return question.getSecondAnswerContent();
        } else if (question.isThirdCorrect()) {
            return question.getThirdAnswerContent();
        } else if (question.isFourthCorrect()) {
            return question.getFourthAnswerContent();
        }
        throw new NoSuchElementException();
    }

    public UserPointsProfile addPointsToUser(long quizId, int points, long userId) {
        return UserPointsMapper.map(userPointsRepository.save(UserPoints.builder()
                .id(userId)
                .user(userService.findUserById(userId))
                .quiz(findQuizById(quizId))
                .points(points)
                .build()));
    }

    private Quiz findQuizById(long id) {
        return quizRepository.findById(id).orElseThrow();
    }

    public void createNewQuizToTopic(long id) {
        Quiz quiz = Quiz.builder()
                .topic(topicService.findById(id))
                .id(id)
                .build();
        quizRepository.save(quiz);
    }
}
