package app.dao;

import app.entity.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Mapper
public interface OrderDetailDao extends BaseMapper<OrderDetail> {
}
