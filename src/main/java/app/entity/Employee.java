package app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author pickjob@126.com
 * @time 2019-05-05
 **/
@Data
@TableName("employees")
public class Employee {
    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;
}
