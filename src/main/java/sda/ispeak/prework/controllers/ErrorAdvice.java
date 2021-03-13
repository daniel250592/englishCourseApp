package sda.ispeak.prework.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sda.ispeak.prework.models.exceptions.IspeakException;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
public class ErrorAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorAdvice.class);


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IspeakException.class)
    public ResponseEntity<Object> handleException(IspeakException exception) {
        LOG.error("exception message {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
        List<ObjectError> allErrors = exception.getAllErrors();
        ObjectError objectError = allErrors.stream().findAny().get();
        LOG.error("exception message {}", objectError.getDefaultMessage());
        return new ResponseEntity<>(objectError.getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        LOG.error("exception message {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
