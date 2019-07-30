package app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * Table: schedule_job
 */
@Data
public class ScheduleJob {
    @TableId(type = IdType.AUTO)
    private Long jobId;
    private String beanName;
    private String beanMethod;
    private String methodParams;
    private String cronExpression;
    private Byte type;
    private Byte status;
    private String remark;
    private Date createTime;
}