package app.model.dto;

import app.common.enums.ScheduleTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class ScheduleJobDto {
    @ApiModelProperty(name = "targetName", value = "目标Bean名称", example = "loggerService", required = true)
    @NotNull(message = "targetName不能为空")
    private String targetName;
    @ApiModelProperty(name = "targetMethod", value = "目标Bean方法", example = "log", required = true)
    @NotNull
    private String targetMethod;
    @ApiModelProperty(name = "targetArguement", value = "目标Bean方法参数", example = "arg", required = true)
    @NotNull
    private String targetArguement;
    @ApiModelProperty(name = "expression", value = "cron表达式", example = "* * * * * *", required = true)
    @NotNull
    private String expression;
    @ApiModelProperty(name = "scheduleTypeEnum", value = "定时任务执行器 1-Spring, 2-Quartz", example = "1", allowableValues = "1,2", required = true)
    @NotNull
    private ScheduleTypeEnum scheduleTypeEnum;
    @ApiModelProperty(name = "remark", value = "备注")
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
