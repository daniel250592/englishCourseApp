package sda.ispeak.prework.models.topic;

import lombok.Builder;
import sda.ispeak.prework.models.questions.Question;
import sda.ispeak.prework.models.users.User;

import javax.persistence.*;
import java.util.Set;

@Builder
@Entity
public class Topic {

    @Id
    private long id;

    private String name;
    private String content;


    @OneToMany
    private Set<User> users;

    public Topic() {
    }

    public Topic(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Topic(long id, String name, String content, Set<User> users) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                ", users=" + users +
                '}';
    }
}
