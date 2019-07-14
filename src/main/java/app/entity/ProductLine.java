package app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Data
@TableName("productlines")
public class ProductLine {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
}
