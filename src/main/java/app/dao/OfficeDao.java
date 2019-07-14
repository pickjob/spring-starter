package app.dao;

import app.entity.Office;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author pickjob@126.com
 * @time 2019-05-05
 **/
@Mapper
public interface OfficeDao extends BaseMapper<Office> {
}
