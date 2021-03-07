package sda.ispeak.prework.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import sda.ispeak.prework.models.dtos.UserDto;
import sda.ispeak.prework.models.exceptions.UserExistException;
import sda.ispeak.prework.models.users.User;
import sda.ispeak.prework.repositories.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    @InjectMocks
    private UserService userService;

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserRepository userRepository;


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
        User expectedUser = User.builder()
                .userName("test")
                .email("test@example.com")
                .id(11)
                .password("!!!")
                .build();
        when(userRepository.save(any())).thenReturn(expectedUser);

        User save = userService.save(userDto);

        assertThat(save.getId()).isEqualTo(11);
    }

    @Test
    @Disabled("Zamienic na kod testu jednostkowego")
    void shouldThrowUserExistException() {
        userService.save(userDto);

        assertThatThrownBy(() -> userService.save(userDto))
                .isExactlyInstanceOf(UserExistException.class)
                .hasMessage("użytkownik taki już istnieje")
                .hasNoCause();
    }
}
