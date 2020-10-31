package spring.starter.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import spring.starter.web.validator.Odd;

/**
 * @author pickjob@126.com
 * @date 2019-08-05
 */
@Schema(name = "校验奇偶性DTO")
public class ValidationDto {
    @Schema(description = "待校验数", required = true, example = "34")
    @Odd
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
