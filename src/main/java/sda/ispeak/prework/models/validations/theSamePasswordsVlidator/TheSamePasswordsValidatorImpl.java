package sda.ispeak.prework.models.validations.theSamePasswordsVlidator;

import org.apache.commons.lang3.StringUtils;
import sda.ispeak.prework.models.dtos.user.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TheSamePasswordsValidatorImpl implements ConstraintValidator<TheSamePasswordsValidator, UserDto> {

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(userDto.getPassword()) || StringUtils.isEmpty(userDto.getConfirmedPassword())) {
            return false;
        }
        return userDto.getPassword().equals(userDto.getConfirmedPassword());
    }
}

