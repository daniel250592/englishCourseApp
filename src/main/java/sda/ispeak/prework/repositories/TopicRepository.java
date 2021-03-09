package sda.ispeak.prework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.ispeak.prework.models.dtos.TopicDto;
import sda.ispeak.prework.models.topic.Topic;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<TopicDto> findAllByOrderByIdAsc();

}
