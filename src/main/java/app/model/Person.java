package app.model;

import lombok.Data;

import javax.validation.Valid;
import java.util.Date;

@Valid
@Data
public class Person {
    private String name;
    private Integer age;
    private Date birthDay;
}
