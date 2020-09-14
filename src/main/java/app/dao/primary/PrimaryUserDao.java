package app.dao.primary;

import app.dao.base.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-08
 */
@Mapper
public interface PrimaryUserDao extends UserMapper {
    Long getUserIdByAccount(@Param("account") String account);
    List<String> getRolesByUserId(@Param("userId") Integer userId);
    List<String> getPermissionsByUserId(@Param("userId") Integer userId);
}
