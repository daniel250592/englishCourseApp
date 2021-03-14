package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.user.UserDto;
import sda.ispeak.prework.models.dtos.user.UserProfile;
import sda.ispeak.prework.models.users.User;

public class UserMapper {

    public static User map(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
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
