package sda.ispeak.prework.models.validations.theSamePasswordsVlidator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sda.ispeak.prework.models.dtos.user.UserDto;

import javax.validation.ConstraintValidatorContext;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TheSamePasswordsValidatorImplTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    private final TheSamePasswordsValidatorImpl theSamePasswordsValidator = new TheSamePasswordsValidatorImpl();

    @Test
    void shouldAssertTrue() {
        UserDto userDto = UserDto.builder()
                .userName("test")
                .email("test@example.com")
                .password("test12345")
                .confirmedPassword("test12345")
                .build();

        boolean valid = theSamePasswordsValidator.isValid(userDto, constraintValidatorContext);

        assertThat(valid).isTrue();

    }

    @Test
    void shouldAssertFalse() {
        UserDto userDto = UserDto.builder()
                .userName("test")
                .email("test@example.com")
                .password("test12345")
                .confirmedPassword("test123456789")
                .build();

        boolean valid = theSamePasswordsValidator.isValid(userDto, constraintValidatorContext);

        assertThat(valid).isFalse();

    }

}