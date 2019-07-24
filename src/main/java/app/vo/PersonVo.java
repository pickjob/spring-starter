package app.vo;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Date;

@Data
public class PersonVo {
    private String name;
    private Integer age;
    private Date birthDay;
}
