package sda.ispeak.prework.models.exceptions;

public class UserExistException extends RuntimeException {
    public UserExistException(String message) {
        super(message);
    }

    public UserExistException() {
    }
}
