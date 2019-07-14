package app.dao;

import app.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-05-05
 **/
@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
}
