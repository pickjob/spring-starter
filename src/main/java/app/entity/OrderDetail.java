package app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Data
@TableName("orderdetails")
public class OrderDetail {
    private Integer orderNumber;
    private String productCode;
    private Integer quantityOrdered;
    private BigDecimal priceEach;
    private Short orderLineNumber;
}
