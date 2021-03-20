//package sda.ispeak.prework.controllers;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.support.DefaultMessageSourceResolvable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import sda.ispeak.prework.models.exceptions.userExceptions.IspeakException;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestControllerAdvice
//@Slf4j
//public class ErrorAdvice {
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(IspeakException.class)
//    public ResponseEntity<Object> handleException(IspeakException exception) {
//        log.error("exception message {}", exception.getMessage());
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
//        List<ObjectError> allErrors = exception.getAllErrors();
//        String allErrorsString = allErrors.stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.joining(";"));
//        log.error("exception message {}", allErrorsString);
//        return new ResponseEntity<>(allErrorsString, HttpStatus.BAD_REQUEST);
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleException(Exception exception) {
//        log.error("exception message {}", exception.getMessage());
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//
//}
