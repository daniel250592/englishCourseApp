package sda.ispeak.prework.models.questions;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
public class Answer {

    @Id
    @GeneratedValue
    private long id;

    private String answerContent;

    private boolean isCorrect;

    public Answer() {
    }

    public Answer(String answerContent, boolean isCorrect) {
        this.answerContent = answerContent;
        this.isCorrect = isCorrect;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
