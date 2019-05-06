package app.dao;

import app.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-04-28
 **/
@Mapper
public interface PaymentDao {
    @Select("select * from payments")
    List<Payment> listAllPayments();
}
