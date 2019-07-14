package app.config;

import app.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceConfiguration {
    @Autowired private PersonValidator personValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(personValidator);
    }

}
