package sda.ispeak.prework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.ispeak.prework.models.entities.topic.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {


}
