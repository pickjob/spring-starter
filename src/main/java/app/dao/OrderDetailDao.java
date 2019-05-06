package app.dao;

import app.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Mapper
public interface OrderDetailDao {
    @Select("select * from orderdetails")
    List<OrderDetail> listAllOrderDetails();
}
