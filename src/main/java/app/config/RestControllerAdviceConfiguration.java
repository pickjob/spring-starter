package app.config;

import app.model.MyResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestControllerAdviceConfiguration {
    private static final Logger logger = LogManager.getLogger(RestControllerAdviceConfiguration.class);

    @ExceptionHandler(BindException.class)
    public ResponseEntity<MyResponse> bindExceptionHandler(BindException bindException) {
        logger.error(bindException.getMessage(), bindException);
        MyResponse myResponse = MyResponse.badRequest(bindException.getFieldError());
        ResponseEntity<MyResponse> resp = new ResponseEntity<>(myResponse, HttpStatus.BAD_REQUEST);
        return resp;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<MyResponse> throwableExceptionHandler(Throwable throwable) {
        logger.error(throwable.getMessage(), throwable);
        MyResponse err = MyResponse.error();
        ResponseEntity<MyResponse> resp = new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        return resp;
    }
}
