package sda.ispeak.prework.models.validations.correctAnswerValidator;

import sda.ispeak.prework.models.validations.theSamePasswordsVlidator.TheSamePasswordsValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CorrectAnswerValidatorImpl.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrectAnswerValidator {
    String message() default "Dokładnie jedna odpowiedź jest poprawna";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
