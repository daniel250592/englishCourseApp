package sda.ispeak.prework.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sda.ispeak.prework.models.dtos.UserDto;
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
public class UserService implements UserDetailsService {

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

    public User activateUserWithGivenId(long id) {
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

    //TODO ten wyjątek nie jest rzucany nie mam pojecia dlaczego.
    public User findUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NoSuchUserException("Użytkownik o podanym ID nie istnieje");
        }
    }


    //TODO nie da sie zalogować poprzez sztywnego uzytkownika
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(s);
        System.out.println(user);
        return new UserDetailsAdapter(user);
    }
}
