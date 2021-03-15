package sda.ispeak.prework.models.validations.samePasswordsVlidator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sda.ispeak.prework.models.dtos.user.NewUserDto;

import javax.validation.ConstraintValidatorContext;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SamePasswordsValidatorImplTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    private final SamePasswordsValidatorImpl theSamePasswordsValidator = new SamePasswordsValidatorImpl();

    @Test
    void shouldAssertTrue() {
        NewUserDto newUserDto = NewUserDto.builder()
                .userName("test")
                .email("test@example.com")
                .password("test12345")
                .confirmedPassword("test12345")
                .build();

        boolean valid = theSamePasswordsValidator.isValid(newUserDto, constraintValidatorContext);

        assertThat(valid).isTrue();
    }

    @Test
    void shouldAssertFalse() {
        NewUserDto newUserDto = NewUserDto.builder()
                .userName("test")
                .email("test@example.com")
                .password("test12345")
                .confirmedPassword("test123456789")
                .build();

        boolean valid = theSamePasswordsValidator.isValid(newUserDto, constraintValidatorContext);

        assertThat(valid).isFalse();
    }

    @Test
    void shouldAssertTrueWhenUserNameAndEmailAreNull() {
        NewUserDto newUserDto = NewUserDto.builder()
                .password("test12345")
                .confirmedPassword("test12345")
                .build();

        boolean valid = theSamePasswordsValidator.isValid(newUserDto, constraintValidatorContext);

        assertThat(valid).isTrue();
    }

}