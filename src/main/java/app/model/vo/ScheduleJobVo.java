package app.model.vo;

import lombok.Data;

@Data
public class ScheduleJobVo {
    private String targetName;
    private String targetMethod;
    private String targetArguement;
    private String expression;
}
