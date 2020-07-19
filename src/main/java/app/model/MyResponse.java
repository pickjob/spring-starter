package app.model;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.HashMap;

public class MyResponse implements Serializable {
    private int code;
    private String description;
    private Object data;

    public static MyResponse success() {
        return success(new HashMap<>());
    }

    public static MyResponse success(Object data) {
        return response(200, "success", data);
    }

    public static MyResponse badRequest(FieldError fieldError) {
        return response(400, String.format("field: %s, rejectValue: %s, message: %s", fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage()), new HashMap<>());
    }

    public static MyResponse unauthened(UnauthenticatedException e) {
        return response(401, e.getMessage(), new HashMap<>());
    }

    public static MyResponse unauthorized(AuthorizationException e) {
        return response(403, e.getMessage(), new HashMap<>());
    }

    public static MyResponse error(String msg) {
        return response(500, msg, new HashMap<>());
    }

    private static MyResponse response(int code, String description, Object data) {
        MyResponse response = new MyResponse();
        response.setCode(code);
        response.setDescription(description);
        response.setData(data);
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
