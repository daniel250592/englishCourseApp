package sda.ispeak.prework.controllers;

import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.user.NewUserDto;
import sda.ispeak.prework.models.dtos.user.UserProfile;
import sda.ispeak.prework.services.UserService;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserProfile addNewUser(@RequestBody @Valid NewUserDto newUserDto) {
        return userService.save(newUserDto);
    }

    @GetMapping("/activate-account/{id}")
    public UserProfile activateUserAccount(@PathVariable long id) {
        return userService.activateUserWithGivenId(id);
    }
}
