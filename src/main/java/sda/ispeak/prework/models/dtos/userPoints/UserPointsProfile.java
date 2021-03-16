package sda.ispeak.prework.models.dtos.userPoints;

import lombok.*;
import sda.ispeak.prework.models.dtos.user.UserProfile;
import sda.ispeak.prework.models.entities.quiz.Quiz;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPointsProfile {

    private long id;

    private Quiz quiz;

    private UserProfile userProfile;
}
