package sda.ispeak.prework.models.users;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
public class User {

    @Id
    @GeneratedValue
    private long id;


    private String email;
    private String userName;
    private String password;
    private String role = "USER";
    private boolean active = false;

    public User() {
    }

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
