package app.model.entity;

import app.common.enums.ScheduleTypeEnum;
import app.common.enums.ScheduleStatusEnum;

import java.util.Date;

/**
 * Table: schedule_job
 */
public class ScheduleJob {
    /**
     * Column: id
     * Remark: 任务id
     */
    private Long id;

    /**
     * Column: target_bean
     * Remark: spring bean名称
     */
    private String targetBean;

    /**
     * Column: target_method
     * Remark: spring bean方法
     */
    private String targetMethod;

    /**
     * Column: target_argument
     * Remark: 方法参数
     */
    private String targetArgument;

    /**
     * Column: cron_expression
     * Remark: cron表达式
     */
    private String cronExpression;

    /**
     * Column: schedule_type
     * Remark: 定时任务类型: 1-spring 2-quartz
     */
    private ScheduleTypeEnum scheduleType;

    /**
     * Column: schedule_status
     * Remark: 任务状态: 0-正常 1-暂停 2-删除
     */
    private ScheduleStatusEnum scheduleStatus;

    /**
     * Column: remark
     * Remark: 备注
     */
    private String remark;

    /**
     * Column: create_time
     * Remark: 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTargetBean() {
        return targetBean;
    }

    public void setTargetBean(String targetBean) {
        this.targetBean = targetBean;
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

    public String getTargetArgument() {
        return targetArgument;
    }

    public void setTargetArgument(String targetArgument) {
        this.targetArgument = targetArgument;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public ScheduleTypeEnum getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(ScheduleTypeEnum scheduleType) {
        this.scheduleType = scheduleType;
    }

    public ScheduleStatusEnum getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(ScheduleStatusEnum scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}