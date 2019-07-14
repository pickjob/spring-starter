package app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author pickjob@126.com
 * @time 2019-04-28
 **/
@Data
@TableName("payments")
public class Payment {
    private Integer customerNumber;
    private String checkNumber;
    private Date paymentDate;
    private BigDecimal amount;
}
