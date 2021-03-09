package sda.ispeak.prework.models.topic;

import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.models.users.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Topic {

    @Id
    private long id;

    private String name;
    private String content;

    @OneToOne
    private Quiz quiz;

    @OneToMany
    private Set<User> users;

    public Topic() {
    }

    public Topic(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Topic(long id, String name, String content, Quiz quiz, Set<User> users) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.quiz = quiz;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", quiz=" + quiz +
                ", users=" + users +
                '}';
    }
}
