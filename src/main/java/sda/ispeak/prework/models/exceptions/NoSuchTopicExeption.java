package sda.ispeak.prework.models.exceptions;

import sda.ispeak.prework.models.exceptions.userExceptions.IspeakException;

public class NoSuchTopicExeption extends IspeakException {

    public NoSuchTopicExeption(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
