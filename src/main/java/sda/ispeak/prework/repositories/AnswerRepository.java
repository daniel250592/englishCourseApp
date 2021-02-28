package sda.ispeak.prework.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sda.ispeak.prework.models.questions.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
