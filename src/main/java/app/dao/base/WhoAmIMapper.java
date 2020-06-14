package app.dao.base;

import app.model.entity.WhoAmI;

public interface WhoAmIMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Byte id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(WhoAmI record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(WhoAmI record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    WhoAmI selectByPrimaryKey(Byte id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(WhoAmI record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(WhoAmI record);
}