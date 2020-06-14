package app.model.dto;

import app.validator.Odd;

/**
 * @author pickjob@126.com
 * @time 2019-08-05
 */
public class ValidationDto {
    @Odd
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
