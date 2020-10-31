package spring.starter.data.rdms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import spring.starter.data.rdms.enums.ScheduleTypeEnum;

import javax.validation.constraints.NotNull;

/**
 * @author pickjob@126.com
 * @date 2019-02-21
 */
@Schema(name = "定时任务DTO")
public class ScheduleJobDto {
    @Schema(description = "目标Bean名称", required = true, example = "simpleLoggerService")
    @NotNull(message = "targetName不能为空")
    private String targetName;
    @Schema(description = "目标Bean方法", required = true, example = "log")
    @NotNull
    private String targetMethod;
    @Schema(description = "目标Bean方法参数", required = true, example = "demo args")
    @NotNull
    private String targetArguement;
    @Schema(description = "cron表达式", required = true, example = "*/5 * * * * ?")
    @NotNull
    private String expression;
    @Schema(description = "定时任务执行器 1-Spring, 2-Quartz", required = true, example = "1", allowableValues = {"1", "2"})
    @NotNull
    private ScheduleTypeEnum scheduleTypeEnum;
    @Schema(description = "备注", required = false)
    private String remark;

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

    public String getTargetArguement() {
        return targetArguement;
    }

    public void setTargetArguement(String targetArguement) {
        this.targetArguement = targetArguement;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public ScheduleTypeEnum getScheduleTypeEnum() {
        return scheduleTypeEnum;
    }

    public void setScheduleTypeEnum(ScheduleTypeEnum scheduleTypeEnum) {
        this.scheduleTypeEnum = scheduleTypeEnum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
