package app.config;

import app.model.MyResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdviceConfiguration {
    private static final Logger logger = LogManager.getLogger(RestControllerAdviceConfiguration.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<MyResponse> bindExceptionHandler(BindException bindException) {
        logger.error(bindException.getMessage(), bindException);
        MyResponse myResponse = MyResponse.success();
        ResponseEntity<MyResponse> response = new ResponseEntity<>(myResponse, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<MyResponse> throwableExceptionHandler(Throwable throwable) {
        logger.error(throwable.getMessage(), throwable);
        MyResponse myResponse = MyResponse.error();
        ResponseEntity<MyResponse> response = new ResponseEntity<>(myResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}
