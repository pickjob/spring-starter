package app.validator;

import app.vo.PersonVo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonVoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
//        return PersonVo.class.equals(clazz);
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
    }
}
