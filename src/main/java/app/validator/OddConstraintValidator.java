package app.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author pickjob@126.com
 * @date 2019-08-03
 */
@Component
public class OddConstraintValidator implements ConstraintValidator<Odd, Integer> {
    private static final Logger logger = LogManager.getLogger(OddConstraintValidator.class);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        logger.info("validate value: {}", value);
        if (value % 2 == 0) return false;
        else return true;
    }
}
