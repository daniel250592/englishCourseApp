package sda.ispeak.prework.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.user.UserDto;
import sda.ispeak.prework.models.dtos.user.UserProfile;
import sda.ispeak.prework.models.emails.EmailGenerator;
import sda.ispeak.prework.models.emails.EmailSender;
import sda.ispeak.prework.models.exceptions.NoSuchUserException;
import sda.ispeak.prework.models.exceptions.UserExistException;
import sda.ispeak.prework.models.mappers.UserMapper;
import sda.ispeak.prework.models.users.User;
import sda.ispeak.prework.models.users.UserDetailsAdapter;
import sda.ispeak.prework.repositories.UserRepository;

import java.util.Optional;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final EmailSender emailSender;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, EmailSender emailSender) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }


    public UserProfile save(UserDto userDto) {
        User user = UserMapper.map(userDto);
        checkIfUserAlreadyExist(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        emailSender.sendEmail(EmailGenerator.generateEmail(user));
        return UserMapper.map(user);

    }

    public UserProfile activateUserWithGivenId(long id) {
        User user = findUserById(id);
        user.setActive(true);
        return UserMapper.map(updateUser(user));

    }

    private User updateUser(User user) {
        return userRepository.save(user);
    }

    private void checkIfUserAlreadyExist(User user) {

        Optional<User> byEmailAndUserName = userRepository.findByEmailAndUserName(user.getEmail(), user.getUserName());

        if (byEmailAndUserName.isPresent()) {
            throw new UserExistException("Użytkownik taki już istnieje");
        }
    }

    private User findUserById(long id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() ->
                new NoSuchUserException("Użytkownik o podanym ID nie istnieje")
        );

        //Tak nie robic
//        if (user.isPresent()) {
//            return user.get();
//        } else {
//            throw new NoSuchUserException("Użytkownik o podanym ID nie istnieje");
//        }
    }

    //TODO nie da sie zalogować poprzez sztywnego uzytkownika
    @Override
    public UserDetails loadUserByUsername(String s) {
        User user = userRepository.findUserByUserName(s);
        log.debug("loaded user {}", user);
        return new UserDetailsAdapter(user);
    }
}
