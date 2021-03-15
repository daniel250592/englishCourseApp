package sda.ispeak.prework.models.entities.quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import sda.ispeak.prework.models.entities.questions.Question;
import sda.ispeak.prework.models.entities.topic.Topic;
import sda.ispeak.prework.models.entities.users.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Topic topic;

    @OneToMany
    private Set<Question> questions;

    @OneToMany
    private Set<User> users;

    public Quiz() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}