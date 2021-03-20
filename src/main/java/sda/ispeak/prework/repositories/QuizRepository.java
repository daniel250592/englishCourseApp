package sda.ispeak.prework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sda.ispeak.prework.models.entities.quiz.Quiz;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query(value = "SELECT questions_id FROM quiz_questions WHERE quiz_id = :id", nativeQuery = true)
    List<Long> findQuestionsByQuizId(@Param("id") long id);
}
