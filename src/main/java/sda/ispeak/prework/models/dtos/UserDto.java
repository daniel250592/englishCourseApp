package sda.ispeak.prework.models.dtos;

import sda.ispeak.prework.models.validations.theSamePasswordsVlidator.TheSamePasswordsValidator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@TheSamePasswordsValidator
public class UserDto {

    @Email(message = "zły format e-maila")
    private String email;

    @NotNull(message = "nazwa użytkownika nie może być pusta")
    @NotBlank(message = "nazwa użytkownika nie może być pusta")
    @Size(max = 50, message = "nazwa użytkownika nie może być dłuższa niż 50 znaków")
    private String userName;

    @NotNull(message = "hasło nie może być puste")
    @NotBlank(message = "hasło nie może być puste")
    @Size(min = 8, max = 30, message = "hasło powinno zawietać się w przedziale od 8 do 15 znaków")
    private String password;
    private String confirmedPassword;

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

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
