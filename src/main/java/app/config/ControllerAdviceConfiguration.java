package app.config;

import app.model.MyResponse;
import app.validator.PersonVoValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceConfiguration {
    private static final Logger logger = LogManager.getLogger(ControllerAdviceConfiguration.class);
    @Autowired private PersonVoValidator personValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(personValidator);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<MyResponse> exceptionHandler(Throwable throwable) {
        logger.error(throwable.getMessage(), throwable);
        MyResponse myResponse = MyResponse.error();
        ResponseEntity<MyResponse> response = new ResponseEntity<>(myResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}
