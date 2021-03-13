package sda.ispeak.prework.models.mappers;

import org.junit.jupiter.api.Test;
import sda.ispeak.prework.models.dtos.user.UserDto;
import sda.ispeak.prework.models.dtos.user.UserProfile;
import sda.ispeak.prework.models.users.User;

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
    void shouldAssertUserProfileIsNull() {
        User user = User.builder()
                .build();

        UserProfile userProfile = UserMapper.map(user);

        assertThat(userProfile.getUserName()).isNull();
        assertThat(userProfile.getId()).isZero();
        assertThat(userProfile.getEmail()).isNull();
        assertThat(userProfile.isActive()).isFalse();
    }

    @Test
    void shouldAssertUserNotNull(){
        UserDto userDto = UserDto.builder()
                .email("test@example.com")
                .userName("test")
                .password("test12345")
                .confirmedPassword("test12345")
                .build();

        User user = UserMapper.map(userDto);

        assertThat(user.getId()).isZero();
        assertThat(user.getEmail()).isEqualTo(userDto.getEmail());
        assertThat(user.getUserName()).isEqualTo(userDto.getUserName());
        assertThat(user.getPassword()).isEqualTo(userDto.getPassword());
        assertThat(user.getRole()).isEqualTo("USER");
        assertThat(user.isActive()).isFalse();
    }

    @Test
    void shouldAssertUserIsNull(){
        UserDto userDto = UserDto.builder()
                .build();

        User user = UserMapper.map(userDto);

        assertThat(user.getId()).isZero();
        assertThat(user.getEmail()).isNull();
        assertThat(user.getUserName()).isNull();
        assertThat(user.getPassword()).isNull();
        assertThat(user.getRole()).isEqualTo("USER");
        assertThat(user.isActive()).isFalse();
    }

}