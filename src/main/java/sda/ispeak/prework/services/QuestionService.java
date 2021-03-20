package sda.ispeak.prework.services;

import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.question.NewQuestionDto;
import sda.ispeak.prework.models.dtos.question.QuestionProfileDto;
import sda.ispeak.prework.models.entities.questions.Question;
import sda.ispeak.prework.models.mappers.QuestionMapper;
import sda.ispeak.prework.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionProfileDto save(NewQuestionDto newQuestionDto) {
        Question question = QuestionMapper.map(newQuestionDto);
        Question save = questionRepository.save(question);
        return QuestionMapper.map(save);
    }

    public List<QuestionProfileDto> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(QuestionMapper::map)
                .collect(Collectors.toList());
    }

    // TODO: dodac obsluge w kontrolerze
    public boolean delete(long id) {
        Optional<Question> questionById = questionRepository.findById(id);

        return questionById.map(data -> {
            questionRepository.delete(data);
            return true;
        }).orElse(false);

    }

    public QuestionProfileDto getQuestionProfileById(long id) {
        Question question = questionRepository.findById(id).orElseThrow();
        return QuestionMapper.map(question);
    }

    public Question getQuestionById(long id) {
        return questionRepository.findById(id).orElseThrow();
    }

}
