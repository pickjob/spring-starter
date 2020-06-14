package app.dao.base;

import app.model.entity.ScheduleJob;

public interface ScheduleJobMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ScheduleJob record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ScheduleJob record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ScheduleJob selectByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ScheduleJob record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ScheduleJob record);
}