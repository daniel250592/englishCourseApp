package sda.ispeak.prework.models.validations.question;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DifferentQuestionsValidatorImpl.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DifferentQuestionsValidator {

    String message() default "Treść pytania musi się różnić od innych";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
