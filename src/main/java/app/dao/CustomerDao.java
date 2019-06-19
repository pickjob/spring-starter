package app.dao;

import app.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-05-29
 */
@Mapper
public interface CustomerDao {
    @Select("select * from customers")
    List<Customer> listAllCustomers();
}
