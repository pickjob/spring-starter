package app.dao;

import app.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Mapper
public interface OrderDao {
    @Select("select * from orders")
    List<Order> listAllOrders();
}
