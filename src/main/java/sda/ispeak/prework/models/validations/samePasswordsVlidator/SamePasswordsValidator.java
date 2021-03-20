package sda.ispeak.prework.models.validations.samePasswordsVlidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SamePasswordsValidatorImpl.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SamePasswordsValidator {

    String message() default "Hasła różnią się";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
