package sda.ispeak.prework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.ispeak.prework.models.entities.userPoints.UserPoints;

public interface UserPointsRepository extends JpaRepository<UserPoints, Long> {
}
