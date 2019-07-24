package app.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class MyResponse {
    private String code;
    private String description;
    private Object data;

    public static MyResponse success() {
        return response("200", "success", new HashMap<>());
    }

    public static MyResponse error() {
        return response("500", "server error", new HashMap<>());
    }

    public static MyResponse response(String code, String description, Object data) {
        MyResponse response = new MyResponse();
        response.setCode(code);
        response.setDescription(description);
        response.setData(data);
        return response;
    }

}
