package app.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pickjob@126.com
 * @date 2020-06-30
 */
@Mapper
public interface UserDao {
    Long getUserIdByAccount(String account);
    List<String> getRolesByUserId(Integer userId);
    List<String> getPermissionsByUserId(Integer userId);
}
