package app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Data
@TableName("orders")
public class Order {
    private Integer orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private Integer customerNumber;
}
