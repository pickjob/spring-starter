package app.dao;

import app.entity.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author pickjob@126.com
 * @time 2019-04-28
 **/
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {
}
