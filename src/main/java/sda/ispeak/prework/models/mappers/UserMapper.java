package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.user.UserDto;
import sda.ispeak.prework.models.dtos.user.UserDtoToReturn;
import sda.ispeak.prework.models.users.User;

public class UserMapper {

    public static User map(UserDto userDto){
        return User.builder()
                .email(userDto.getEmail())
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .build();
    }

    public static UserDtoToReturn map(User user){
        return UserDtoToReturn.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .isActive(user.isActive())
                .build();
    }
}
