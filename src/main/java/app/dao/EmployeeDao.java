package app.dao;

import app.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-05-05
 **/
@Mapper
public interface EmployeeDao {
    @Select("select * from employees")
    List<Employee> listAllEmployees();
}
