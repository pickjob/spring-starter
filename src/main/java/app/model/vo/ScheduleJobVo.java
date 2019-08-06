package app.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ScheduleJobVo {
    @NotNull(message = "targetName不能为空")
    private String targetName;
    @NotNull
    private String targetMethod;
    @NotNull
    private String targetArguement;
    @NotNull
    private String expression;
}
