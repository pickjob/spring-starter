package app.config;

import app.model.MyResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseEntity<MyResponse> unauthenticatedExceptionHandler(UnauthenticatedException e) {
        logger.error(e.getMessage(), e);
        MyResponse myResponse = MyResponse.unauthened(e);
        ResponseEntity<MyResponse> resp = new ResponseEntity<>(myResponse, HttpStatus.UNAUTHORIZED);
        return resp;
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<MyResponse> authorizationExceptionHandler(AuthorizationException e) {
        logger.error(e.getMessage(), e);
        MyResponse myResponse = MyResponse.unauthorized(e);
        ResponseEntity<MyResponse> resp = new ResponseEntity<>(myResponse, HttpStatus.FORBIDDEN);
        return resp;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<MyResponse> throwableExceptionHandler(Throwable throwable) {
        logger.error(throwable.getMessage(), throwable);
        MyResponse myResponse = MyResponse.error(throwable.getMessage());
        ResponseEntity<MyResponse> resp = new ResponseEntity<>(myResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return resp;
    }
}
