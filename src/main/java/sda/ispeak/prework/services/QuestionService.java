package sda.ispeak.prework.services;

import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.NewQuestionDto;
import sda.ispeak.prework.models.dtos.QuestionProfileDto;
import sda.ispeak.prework.models.mappers.QuestionMapper;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.repositories.QuestionRepository;

import java.util.Comparator;
import java.util.List;
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

    public Object saveQuestionAndReturnId(NewQuestionDto newQuestionDto) {
        return null;
    }


    public Question getQuestionById(long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    public Question delete(long id) {
        Question questionById = getQuestionById(id);
        questionRepository.delete(questionById);
        return questionById;
    }

    public Question update(Question question) {
        Question delete = delete(question.getId());
        questionRepository.save(delete);
        return delete;
    }


}
