package sda.ispeak.prework.models.entities.userPoints;

import lombok.*;
import sda.ispeak.prework.models.entities.quiz.Quiz;
import sda.ispeak.prework.models.entities.users.User;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserPoints {

    @Id
    private long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Quiz quiz;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    private int points;
}
