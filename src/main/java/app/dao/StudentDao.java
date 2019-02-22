package app.dao;

import app.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-02-20
 */
@Mapper
public interface StudentDao {
    @Select("select * from student ")
    List<Student> queryStudentInfo();

    @Insert("insert into student values (#{matricNo}, #{firstName}, #{lastName}, #{dateOfBirth})")
    int createNewStudentInfo(Student newStudent);
}
