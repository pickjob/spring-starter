package spring.starter.message.rocketmq.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @Author ws@yuan-mai.com
 * @Date 2020-11-02
 */
@Tag(name = "Rocketmq DTO 类")
public class RocketmqDto {
    @Schema (description = "消息内容", example = "Message from rocketmq hello world!")
    private String msg;
    @Schema (description = "消息附属消息头键", example = "headerAA")
    private String headerKey;
    @Schema (description = "消息附属消息头值", example = "valueBB")
    private String headerValue;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getHeaderKey() {
        return headerKey;
    }

    public void setHeaderKey(String headerKey) {
        this.headerKey = headerKey;
    }

    public String getHeaderValue() {
        return headerValue;
    }

    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }
}
