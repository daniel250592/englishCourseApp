package sda.ispeak.prework.models.mappers;

import org.junit.jupiter.api.Test;
import sda.ispeak.prework.models.dtos.user.NewUserDto;
import sda.ispeak.prework.models.dtos.user.UserProfile;
import sda.ispeak.prework.models.entities.users.User;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest {

    @Test
    void shouldUserProfileNotNull() {
        User user = User.builder()
                .id(1L)
                .userName("test")
                .email("test@example.com")
                .password("test12345")
                .active(false)
                .role("USER")
                .build();

        UserProfile userProfile = UserMapper.map(user);

        assertThat(userProfile.getEmail()).isEqualTo(user.getEmail());
        assertThat(userProfile.getUserName()).isEqualTo(user.getUserName());
        assertThat(userProfile.getId()).isEqualTo(user.getId());
        assertThat(userProfile.isActive()).isEqualTo(user.isActive());
    }

    @Test
    void shouldAssertUserNotNull(){
        NewUserDto newUserDto = NewUserDto.builder()
                .email("test@example.com")
                .userName("test")
                .password("test12345")
                .confirmedPassword("test12345")
                .build();

        User user = UserMapper.map(newUserDto);

        assertThat(user.getId()).isZero();
        assertThat(user.getEmail()).isEqualTo(newUserDto.getEmail());
        assertThat(user.getUserName()).isEqualTo(newUserDto.getUserName());
        assertThat(user.getPassword()).isEqualTo(newUserDto.getPassword());
        assertThat(user.getRole()).isEqualTo("USER");
        assertThat(user.isActive()).isFalse();
    }

}