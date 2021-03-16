package sda.ispeak.prework.models.entities.quiz;

import lombok.*;
import sda.ispeak.prework.models.entities.questions.Question;
import sda.ispeak.prework.models.entities.topic.Topic;
import sda.ispeak.prework.models.entities.users.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quiz {

    @Id
    private long id;

    @OneToOne
    private Topic topic;

    @OneToMany
    private Set<Question> questions;

    @OneToMany
    private Set<User> users;

}