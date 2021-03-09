package sda.ispeak.prework.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import sda.ispeak.prework.models.dtos.user.UserDto;
import sda.ispeak.prework.models.dtos.user.UserDtoToReturn;
import sda.ispeak.prework.models.emails.EmailSender;
import sda.ispeak.prework.models.exceptions.NoSuchUserException;
import sda.ispeak.prework.models.exceptions.UserExistException;
import sda.ispeak.prework.models.users.User;
import sda.ispeak.prework.repositories.UserRepository;

import java.util.Optional;

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
    @Mock
    private EmailSender emailSender;


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

        UserDtoToReturn save = userService.save(userDto);

        assertThat(save.getId()).isEqualTo(11);
    }

    @Test
    void shouldThrowUserExistException() {

        when(userRepository.save(any())).thenThrow(new UserExistException("Użytkownik taki już istnieje"));

        assertThatThrownBy(() -> userService.save(userDto))
                .isExactlyInstanceOf(UserExistException.class)
                .hasMessage("Użytkownik taki już istnieje")
                .hasNoCause();
    }

    @Test
    void shouldReturnUserDetails(){
        when(userRepository.findUserByUserName("test")).thenReturn(User.builder()
                .userName("test")
                .build());

        UserDetails test = userService.loadUserByUsername("test");

        assertThat(test.getUsername()).isEqualTo("test");
    }

    @Test
    void shouldReturnIdNotNull(){
        when(userRepository.findById(1L)).thenReturn(Optional.of(User.builder()
                .id(1)
                .build()));

        when(userRepository.save(any())).thenReturn(User.builder()
                .id(1)
                .build());

        UserDtoToReturn user = userService.activateUserWithGivenId(1L);

        assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    void shouldThrowNoSuchUserException() {

        when(userRepository.findById(any())).thenThrow(new NoSuchUserException("Użytkownik o podanym ID nie istnieje"));

        assertThatThrownBy(() -> userService.activateUserWithGivenId(1L))
                .isExactlyInstanceOf(NoSuchUserException.class)
                .hasMessage("Użytkownik o podanym ID nie istnieje")
                .hasNoCause();
    }

    @Test
    @Disabled
    void shouldReturnActiveAccount(){
        User user = new User();
        user.setActive(true);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        when(userRepository.save(any())).thenReturn(User.builder()
                .id(1)
                .active(true)
                .build());

        UserDtoToReturn withGivenId = userService.activateUserWithGivenId(1L);

        assertThat(withGivenId.isActive()).isEqualTo(true);
    }

}
