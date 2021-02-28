package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.UserDto;
import sda.ispeak.prework.models.users.User;

public class UserMapper {

    public static User map(UserDto userDto){
        return new User(userDto.getEmail(),userDto.getUserName(),userDto.getPassword());
    }
}
