package sda.ispeak.prework.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import sda.ispeak.prework.models.dtos.user.NewUserDto;
import sda.ispeak.prework.models.dtos.user.UserProfile;
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


    private NewUserDto newUserDto;


    @BeforeEach
    void returnUser() {
        this.newUserDto = new NewUserDto();
        this.newUserDto.setUserName("test");
        this.newUserDto.setEmail("test@example.com");
        this.newUserDto.setPassword("password");
        this.newUserDto.setConfirmedPassword("password");

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

        UserProfile save = userService.save(newUserDto);

        assertThat(save.getId()).isEqualTo(11);
    }

    @Test
    void shouldThrowUserExistException() {

        when(userRepository.save(any())).thenThrow(new UserExistException("Użytkownik taki już istnieje"));

        assertThatThrownBy(() -> userService.save(newUserDto))
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
        when(userRepository.findById(any())).thenReturn(Optional.of(User.builder()
                .id(1)
                .build()));

        when(userRepository.save(any())).thenReturn(User.builder()
                .id(1)
                .build());

        UserProfile user = userService.activateUserWithGivenId(1L);

        assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    void shouldThrowNoSuchUserException() {

        when(userRepository.findById(any())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.activateUserWithGivenId(1L))
                .isExactlyInstanceOf(NoSuchUserException.class)
                .hasMessage("Użytkownik o podanym ID nie istnieje")
                .hasNoCause();
    }

    @Test
    void shouldReturnActiveAccount(){
        User user = new User();
        user.setActive(false);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        when(userRepository.save(any())).thenReturn(User.builder()
                .id(1)
                .active(true)
                .build());

        UserProfile withGivenId = userService.activateUserWithGivenId(1L);

        assertThat(withGivenId.isActive()).isEqualTo(true);
    }

}
