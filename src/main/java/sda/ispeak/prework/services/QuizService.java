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
import java.util.stream.Collectors;

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

    private List<Long> getQuestionsIdsFromGivenTopic(long topicId) {
        topicService.findById(topicId);
        return getQuestionsIdsFromGivenQuiz(topicId);
    }

    public QuestionProfileWithoutCorrectness getQuestionFromGivenQuizAndCheckCorrectness(long topicId, AnswerDto answerDto, long userId) {
        try {
            if (answerDto.getQuestionId() != 0) {
                QuestionProfileWithoutCorrectness questionFromGivenQuiz = getQuestionFromGivenQuiz(topicId);
                questionFromGivenQuiz.setQuizScore(answerDto.getQuizScore());
                if (checkAnswerCorrectness(answerDto)) {
                    questionFromGivenQuiz.setQuizScore(questionFromGivenQuiz.getQuizScore() + 1);
                }
                return questionFromGivenQuiz;
            } else return getQuestionFromGivenQuiz(topicId);
        } catch (NoSuchElementException exception) {
            QuestionProfileWithoutCorrectness questionProfileWithoutCorrectness = new QuestionProfileWithoutCorrectness();
            questionProfileWithoutCorrectness.setQuizScore(answerDto.getQuizScore());
            questionProfileWithoutCorrectness.setQuestion(exception.getMessage());
            if (checkAnswerCorrectness(answerDto)) {
                questionProfileWithoutCorrectness.setQuizScore(questionProfileWithoutCorrectness.getQuizScore() + 1);
            }
            addPointsToUser(topicId, questionProfileWithoutCorrectness.getQuizScore(), userId);
            return questionProfileWithoutCorrectness;
        }
    }

    public QuestionProfileWithoutCorrectness getQuestionFromGivenQuiz(long topicId) {
        if (questionIdManager.isEmpty()) {
            List<Long> questionsIdsFromGivenTopic = getQuestionsIdsFromGivenTopic(topicId);
            questionIdManager.addValuesToQueue(questionsIdsFromGivenTopic);
        }
        if (questionIdManager.peekNextId() != null) {
            return QuestionMapper.mapAndReturnQuestionProfileWithoutCorrectness(questionService.findQuestionById(questionIdManager.pollNextId()));
        } else {
            throw new NoSuchElementException("Quiz zakończony");
        }

    }

    private boolean checkAnswerCorrectness(AnswerDto answerDto) {
        Question questionById = questionService.findQuestionById(answerDto.getQuestionId());
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

    private UserPointsProfile addPointsToUser(long quizId, int points, long userId) {
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

    public List<QuestionProfileDto> assignQuestionToQuiz(long questionId, long quizId) {
        Question question = questionService.findQuestionById(questionId);
        Quiz quiz = findQuizById(quizId);
        quiz.getQuestions().add(question);
        Quiz save = quizRepository.save(quiz);
        return save.getQuestions().stream().map(QuestionMapper::map).collect(Collectors.toList());

    }
}
