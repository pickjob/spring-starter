package app.model.vo;

import app.validator.annotation.Email;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author pickjob@126.com
 * @time 2019-08-05
 */
@Data
public class PersonVo {
    @Email private String email;
}
