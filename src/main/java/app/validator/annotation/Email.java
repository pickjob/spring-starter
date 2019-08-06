package app.validator.annotation;

import app.validator.constraint.EmailConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author pickjob@126.com
 * @time 2019-08-03
 */
@Documented
@Constraint(validatedBy = EmailConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default "Email校验不通过";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
