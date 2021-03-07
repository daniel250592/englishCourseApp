package sda.ispeak.prework.models.topic;

import sda.ispeak.prework.models.questions.Question;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    private Set<Question> questions;


}
