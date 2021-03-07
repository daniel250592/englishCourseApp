package sda.ispeak.prework.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import sda.ispeak.prework.models.dtos.UserDto;
import sda.ispeak.prework.models.exceptions.UserExistException;
import sda.ispeak.prework.models.users.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserDto userDto;


    @BeforeEach
    void returnUser() {
        this.userDto = new UserDto();
        this.userDto.setUserName("test");
        this.userDto.setEmail("test@example.com");
        this.userDto.setPassword("password");
        this.userDto.setConfirmedPassword("password");

    }

    @Test
    void shouldIdNotNull() {
        User save = userService.save(userDto);

        assertThat(save.getId()).isNotZero();
    }

    @Test
    void shouldReturnUser() {
        User save = userService.save(userDto);
        User user = userService.findUserById(save.getId());

        assertTrue(passwordEncoder.matches(userDto.getPassword(), user.getPassword()));
    }

    @Test
    void shouldThrowUserExistException() {
        userService.save(userDto);

        assertThatThrownBy(() -> userService.save(userDto))
                .isExactlyInstanceOf(UserExistException.class)
                .hasMessage("użytkownik taki już istnieje")
                .hasNoCause();
    }
}
