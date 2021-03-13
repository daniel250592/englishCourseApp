package sda.ispeak.prework.controllers;

import org.springframework.web.bind.annotation.*;
import sda.ispeak.prework.models.dtos.user.UserDto;
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

    @PostMapping("/add-new-user")
    public UserProfile addNewUser(@RequestBody @Valid UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping("/activate-your-account{id}")
    public UserProfile activateUserAccount(@PathVariable long id) {
        return userService.activateUserWithGivenId(id);
    }
}
