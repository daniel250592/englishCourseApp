package sda.ispeak.prework.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.UserDto;
import sda.ispeak.prework.models.emails.EmailGenerator;
import sda.ispeak.prework.models.emails.EmailSender;
import sda.ispeak.prework.models.exceptions.UserExistException;
import sda.ispeak.prework.models.mappers.UserMapper;
import sda.ispeak.prework.models.users.User;
import sda.ispeak.prework.repositories.UserRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    public User save(UserDto userDto) {
        User user = UserMapper.map(userDto);
        checkIfUserAlreadyExist(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        EmailSender.sendEmail(EmailGenerator.generateEmail(user));
        return user;
    }

    public User activateUserWithGivenId(long id){
        User user = findUserById(id);
        user.setActive(true);
        return user;
    }

    private void checkIfUserAlreadyExist(User user) {
        Optional<User> byEmailAndUserName = userRepository.findByEmailAndUserName(user.getEmail(), user.getUserName());
        if (byEmailAndUserName.isPresent()) {
            throw new UserExistException("użytkownik taki już istnieje");
        }
    }

    public User findUserById(long id){
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        //TODO tutaj trzeba zrobic własny wyjątek
    }
}
