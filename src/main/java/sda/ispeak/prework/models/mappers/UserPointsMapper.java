package sda.ispeak.prework.models.mappers;

import sda.ispeak.prework.models.dtos.userPoints.UserPointsProfile;
import sda.ispeak.prework.models.entities.userPoints.UserPoints;

public class UserPointsMapper {

    public static UserPointsProfile map (UserPoints userPoints){
        return UserPointsProfile.builder()
                .id(userPoints.getId())
                .quiz(userPoints.getQuiz())
                .userProfile(UserMapper.map(userPoints.getUser()))
                .build();
    }
}
