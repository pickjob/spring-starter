package app.model.dto;

import app.validator.Odd;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author pickjob@126.com
 * @date 2019-08-05
 */
public class ValidationDto {
    @Schema(name = "number", description = "待校验数", required = true, example = "34")
    @Odd
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
