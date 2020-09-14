package app.dao.secondary;

import app.dao.base.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-08
 */
@Mapper
public interface SecondaryUserDao extends UserMapper {
}
