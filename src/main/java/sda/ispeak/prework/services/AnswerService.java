package sda.ispeak.prework.services;
/*
import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.AnswerDto;
import sda.ispeak.prework.models.forms.FourAnswersForm;
import sda.ispeak.prework.models.mappers.AnswerMapper;
import sda.ispeak.prework.models.mappers.FourAnswersMapper;
import sda.ispeak.prework.models.questions.Question;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    public AnswerService(AnswerRepository answerRepository, QuestionService questionService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
    }

    public Answer save(AnswerDto answerDto) {
        return answerRepository.save(AnswerMapper.map(answerDto));
    }

    public Answer updateAnswerContent(long id, AnswerDto answerDto) {
        Answer answer = answerRepository.findById(id).orElseThrow(NoSuchElementException::new);
        answer.setAnswerContent(answerDto.getAnswerContent());
        return answer;
    }

    public Answer updateAnswerCorrectness(long id, AnswerDto answerDto) {
        Answer answer = answerRepository.findById(id).orElseThrow(NoSuchElementException::new);
        answer.setCorrect(answerDto.isCorrect());
        return answer;
    }

    public Answer findAnswerById(long id) {
        return answerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Long> saveAnswersReturnListId(FourAnswersForm fourAnswers) {
        return FourAnswersMapper.map(fourAnswers).stream()
                .peek(answerRepository::save)
                .map(Answer::getId)
                .collect(Collectors.toList());
    }

    public List<Answer> saveAnswers(FourAnswersForm fourAnswersForm) {
        return FourAnswersMapper.map(fourAnswersForm).stream()
                .peek(answerRepository::save)
                .collect(Collectors.toList());
    }

    public Question connectAnswersToQuestion(long temp, FourAnswersForm fourAnswers) {
        List<Answer> answers = saveAnswers(fourAnswers);
        Question questionById = questionService.getQuestionById(temp);
        questionById.setAnswers(new HashSet<>(answers));
        return questionService.update(questionById);
    }


    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }
}
*/