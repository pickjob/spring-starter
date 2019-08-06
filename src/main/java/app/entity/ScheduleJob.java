package app.entity;

import app.common.StatusEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ScheduleJob {
    /**
     * Column: job_id
     * Remark: 任务id
     */
    @TableId(type = IdType.AUTO)
    private Long jobId;

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
     * Column: type
     * Remark: 定时任务类型: 1-spring 2-quartz
     */
    private Byte type;

    /**
     * Column: status
     * Remark: 任务状态: 0-正常 1-暂停 2-删除
     */
    private StatusEnum status;

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
}