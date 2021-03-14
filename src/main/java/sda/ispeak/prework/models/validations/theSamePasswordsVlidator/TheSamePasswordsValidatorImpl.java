package sda.ispeak.prework.models.validations.theSamePasswordsVlidator;

import sda.ispeak.prework.models.dtos.user.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TheSamePasswordsValidatorImpl implements ConstraintValidator<TheSamePasswordsValidator, UserDto> {


    @Override
    public void initialize(TheSamePasswordsValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        return userDto.getPassword().equals(userDto.getConfirmedPassword());
    }


}

