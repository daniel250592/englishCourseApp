package sda.ispeak.prework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.UserDto;
import sda.ispeak.prework.models.exceptions.NoSuchUserException;
import sda.ispeak.prework.models.exceptions.UserExistException;
import sda.ispeak.prework.services.UserService;
import sda.ispeak.prework.models.users.User;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add-new-user")
    public User addNewUser(@RequestBody @Valid UserDto userDto){
        return userService.save(userDto);
    }

    @GetMapping("/activate-your-account{id}")
    public User activateUserAccount(@PathVariable long id){
       return userService.activateUserWithGivenId(id);
    }

    //TODO tu jest coś zle, ale nie wiem co

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handleNoSuchElementException(UserExistException userExistException) {
        return new ResponseEntity<>(userExistException.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchUserException noSuchUserException) {
        return new ResponseEntity<>(noSuchUserException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
