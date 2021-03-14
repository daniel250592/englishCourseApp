package sda.ispeak.prework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.models.topic.Topic;

import java.sql.ResultSet;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query(nativeQuery = true, value = "SELECT questions_id FROM quiz_questions WHERE quiz_id = 1 AND questions_id = 1")
    int findQuestion();
}
