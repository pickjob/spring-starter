package app.model.vo;

import lombok.Data;

@Data
public class ScheduledTaskVo {
    private String targetName;
    private String targetMethod;
    private String targetArguement;
    private String expression;
}
