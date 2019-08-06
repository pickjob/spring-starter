package app.validator.constraint;

import app.validator.annotation.Email;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author pickjob@126.com
 * @time 2019-08-03
 */
@Component
public class EmailConstraintValidator implements ConstraintValidator<Email, String> {
    private static final Logger logger = LogManager.getLogger(EmailConstraintValidator.class);
    private static final Pattern pattern = Pattern.compile(".+@.+\\\\.[a-z]+");
    private Email emailConstraint;

    @Override
    public void initialize(Email emailConstraint) {
        this.emailConstraint = emailConstraint;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if (pattern.matcher(value).matches()) return true;
//        throw new BindException();
        return false;
    }
}
