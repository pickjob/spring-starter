package app.dao;

import app.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author pickjob@126.com
 * @time 2019-05-29
 */
@Mapper
public interface CustomerDao extends BaseMapper<Customer> {
}
