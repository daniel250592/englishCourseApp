package sda.ispeak.prework.services;

import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.QuestionDto;
import sda.ispeak.prework.models.mappers.QuestionMapper;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.repositories.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Object saveQuestionAndReturnId(QuestionDto questionDto) {
        return null;
    }
    /** TODO tu trzeba zmienić na odpowiednie DTO **/

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
