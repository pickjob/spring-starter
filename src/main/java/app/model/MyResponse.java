package app.model;

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

    public static MyResponse error() {
        return response(500, "server error", new HashMap<>());
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
