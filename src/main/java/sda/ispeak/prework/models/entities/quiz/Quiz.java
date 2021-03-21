package sda.ispeak.prework.models.entities.quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sda.ispeak.prework.models.entities.questions.Question;
import sda.ispeak.prework.models.entities.topic.Topic;
import sda.ispeak.prework.models.entities.users.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    private long id;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private Topic topic;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Question> questions;


    //TODO nie wiem dlaczego przy takim ustawieniu nie kasuje relacyjnych rekordow

}