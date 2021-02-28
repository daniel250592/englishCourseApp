package sda.ispeak.prework.models.validations.theSamePasswordsVlidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TheSamePasswordsValidatorImpl.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TheSamePasswordsValidator {

    String message() default "hasła różnią się";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
