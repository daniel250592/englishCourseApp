package sda.ispeak.prework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.ispeak.prework.models.entities.users.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailOrUserName(String email, String userName);

    User findUserByUserName(String username);
}
