package sda.ispeak.prework.models.dtos.user;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    private long id;
    private String userName;
    private String email;
    private boolean isActive;
}
