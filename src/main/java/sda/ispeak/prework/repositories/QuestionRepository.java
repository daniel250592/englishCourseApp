package sda.ispeak.prework.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sda.ispeak.prework.models.questions.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
