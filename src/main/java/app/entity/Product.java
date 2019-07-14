package app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Data
@TableName("products")
public class Product {
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Short quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal msrp;
}
