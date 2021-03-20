package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.user.NewUserDto;
import sda.ispeak.prework.models.dtos.user.UserProfile;
import sda.ispeak.prework.models.entities.users.User;

public class UserMapper {

    private UserMapper() {}

    public static User map(NewUserDto newUserDto) {
        return User.builder()
                .email(newUserDto.getEmail())
                .userName(newUserDto.getUserName())
                .password(newUserDto.getPassword())
                .role("USER")
                .active(false)
                .build();
    }

    public static UserProfile map(User user) {
        return UserProfile.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .isActive(user.isActive())
                .build();
    }
}
