package sda.ispeak.prework.models.questions;

import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
public class Question {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private QuestionSubject subject;


    private String content;

    @OneToMany
    private Set<Answer> answers;


    public Question() {
    }

    public Question(String subject, String content, Set<Answer> answers) {
        this.subject = QuestionSubject.valueOf(subject);
        this.content = content;
        this.answers = answers;
    }

    public Question(String subject, String content) {
        this.subject = QuestionSubject.valueOf(subject);
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public QuestionSubject getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = QuestionSubject.valueOf(subject);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
