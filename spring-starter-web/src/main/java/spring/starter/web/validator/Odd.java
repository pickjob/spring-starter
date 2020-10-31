package spring.starter.web.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author pickjob@126.com
 * @date 2019-08-03
 */
@Constraint(validatedBy = OddConstraintValidator.class)
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Odd {
    String message() default "不是奇数";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
