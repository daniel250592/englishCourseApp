package sda.ispeak.prework.models.validations.samePasswordsVlidator;

import org.apache.commons.lang3.StringUtils;
import sda.ispeak.prework.models.dtos.user.NewUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordsValidatorImpl implements ConstraintValidator<SamePasswordsValidator, NewUserDto> {

    @Override
    public boolean isValid(NewUserDto newUserDto, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(newUserDto.getPassword()) || StringUtils.isEmpty(newUserDto.getConfirmedPassword())) {
            return false;
        }
        return newUserDto.getPassword().equals(newUserDto.getConfirmedPassword());
    }
}

