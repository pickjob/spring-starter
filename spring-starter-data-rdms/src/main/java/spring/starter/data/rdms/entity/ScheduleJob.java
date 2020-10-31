package spring.starter.data.rdms.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import spring.starter.data.rdms.enums.ScheduleStatusEnum;
import spring.starter.data.rdms.enums.ScheduleTypeEnum;

import javax.persistence.*;
import java.util.Date;

/**
 * Table: schedule_job
 */
@Table(name = "schedule_job")
@Entity
public class ScheduleJob {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Schema( description = "spring bean名称")
    private String targetBean;
    @Schema( description = "spring bean方法")
    private String targetMethod;
    @Schema( description = "方法参数")
    private String targetArgument;
    @Schema( description = "cron表达式")
    private String cronExpression;
    @Schema( description = "定时任务类型: 1-spring 2-quartz")
    private ScheduleTypeEnum scheduleType;
    @Schema( description = "任务状态: 0-正常 1-暂停 2-删除")
    private ScheduleStatusEnum scheduleStatus;
    @Schema( description = "备注")
    private String remark;
    @Schema( description = "创建时间")
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