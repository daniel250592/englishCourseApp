package sda.ispeak.prework.controllers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sda.ispeak.prework.models.dtos.user.UserDto;
import sda.ispeak.prework.models.dtos.user.UserProfile;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserControllerITest {

    @Autowired
    private UserController userController;

    @Test
    void shouldReturnTrue() {

        UserDto userDto = UserDto.builder()
                .email("test@test.com")
                .password("example123")
                .confirmedPassword("example123")
                .userName("test")
                .build();

        UserProfile userProfile = userController.addNewUser(userDto);

        assertThat(userProfile.getEmail()).isEqualTo(userDto.getEmail());
    }

    @Test
    @Disabled
    void shouldReturnFalse() {

        UserDto userDto = UserDto.builder()
                .email("test@example.com")
                .password("example123")
                .confirmedPassword("example123")
                .email("")
                .build();
    //TODO niestety nie mam pojecia jak zasymulawać wysłanie metody post

    }
}