package app.dao.base;

import app.model.entity.Role;

public interface RoleMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Role record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Role record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Role selectByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Role record);
}