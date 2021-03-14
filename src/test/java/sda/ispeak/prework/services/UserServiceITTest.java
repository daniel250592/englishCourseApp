package sda.ispeak.prework.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import sda.ispeak.prework.models.dtos.user.NewUserDto;
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

    private NewUserDto newUserDto;


    @BeforeEach
    void returnUser() {
        this.newUserDto = new NewUserDto();
        this.newUserDto.setUserName("testtest");
        this.newUserDto.setEmail("test@exampletest.com");
        this.newUserDto.setPassword("password");
        this.newUserDto.setConfirmedPassword("password");

    }

    @Test
    void shouldIdNotNull() {
        UserProfile save = userService.save(newUserDto);

        assertThat(save.getId()).isNotZero();
    }

    @Test
    void shouldThrowUserExistException() {
        userService.save(newUserDto);

        assertThatThrownBy(() -> userService.save(newUserDto))
                .isExactlyInstanceOf(UserExistException.class)
                .hasMessage("Użytkownik taki już istnieje")
                .hasNoCause();
    }
}
