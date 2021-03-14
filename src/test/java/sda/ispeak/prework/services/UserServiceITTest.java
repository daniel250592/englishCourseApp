package sda.ispeak.prework.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import sda.ispeak.prework.models.dtos.user.UserDto;
import sda.ispeak.prework.models.dtos.user.UserProfile;
import sda.ispeak.prework.models.exceptions.UserExistException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
@Transactional
class UserServiceITTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserDto userDto;


    @BeforeEach
    void returnUser() {
        this.userDto = new UserDto();
        this.userDto.setUserName("testtest");
        this.userDto.setEmail("test@exampletest.com");
        this.userDto.setPassword("password");
        this.userDto.setConfirmedPassword("password");

    }

    @Test
    void shouldIdNotNull() {
        UserProfile save = userService.save(userDto);

        assertThat(save.getId()).isNotZero();
    }

    @Test
    void shouldThrowUserExistException() {
        userService.save(userDto);

        assertThatThrownBy(() -> userService.save(userDto))
                .isExactlyInstanceOf(UserExistException.class)
                .hasMessage("Użytkownik taki już istnieje")
                .hasNoCause();
    }
}
