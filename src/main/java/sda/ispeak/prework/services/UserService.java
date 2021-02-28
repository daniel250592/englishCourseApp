package sda.ispeak.prework.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.UserDto;
import sda.ispeak.prework.models.emails.EmailSender;
import sda.ispeak.prework.models.emails.MyEmail;
import sda.ispeak.prework.models.exceptions.UserExistException;
import sda.ispeak.prework.models.mappers.UserMapper;
import sda.ispeak.prework.models.users.User;
import sda.ispeak.prework.repositories.UserRepository;

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
        EmailSender.sendEmail(new MyEmail("Witaj użytkowniku " + userDto.getUserName(),"Udało Ci się założyć konto w aplikacji",userDto.getEmail()));
        return userRepository.save(user);
    }

    private void checkIfUserAlreadyExist(User user) {
        Optional<User> byEmailAndUserName = userRepository.findByEmailAndUserName(user.getEmail(), user.getUserName());
        if (byEmailAndUserName.isPresent()) {
            throw new UserExistException("użytkownik taki już istnieje");
        }
    }
}
