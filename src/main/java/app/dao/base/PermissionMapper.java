package app.dao.base;

import app.model.entity.Permission;

public interface PermissionMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Permission record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Permission record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Permission selectByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Permission record);
}