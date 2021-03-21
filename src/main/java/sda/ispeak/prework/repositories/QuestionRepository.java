package sda.ispeak.prework.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sda.ispeak.prework.models.entities.questions.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM QUESTION WHERE ID=:id")
    int deleteQuestionByID(@Param("id") long id);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM QUIZ_QUESTIONS WHERE QUESTIONS_ID = :id")
    int deleteQuizQuestionById(@Param("id") long id);
}
