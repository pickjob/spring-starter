package app.controller;

import app.model.MyResponse;
import app.model.dto.ScheduleJobDto;
import app.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author pickjob@126.com
 * @date 2019-02-21
 */
@Tag(name = "定时任务示例")
@RequestMapping("/v1/schedule")
@RestController
public class ScheduleController {
    private static final Logger logger = LogManager.getLogger(ScheduleController.class);
    @Autowired private ScheduleService scheduleService;

    @Operation(
            summary = "添加定时任务--表单",
            security = { @SecurityRequirement(name = "auth") },
            parameters = {
                    @Parameter(name = "targetName", description = "目标Bean名称", in = ParameterIn.QUERY, required = true, example = "loggerService"),
                    @Parameter(name = "targetMethod", description = "目标Bean方法", in = ParameterIn.QUERY, required = true, example = "log"),
                    @Parameter(name = "targetArguement", description = "目标Bean方法参数", in = ParameterIn.QUERY, required = true, example = "arg"),
                    @Parameter(name = "expression", description = "cron表达式", in = ParameterIn.QUERY, required = true, example = "* * * * * *"),
                    @Parameter(name = "scheduleTypeEnum", description = "定时任务执行器 1-Spring, 2-Quartz", in = ParameterIn.QUERY, required = true, example = "1", schema = @Schema(allowableValues = {"1", "2"})),
                    @Parameter(name = "remark", description = "备注", in = ParameterIn.QUERY, required = true)
            }
    )
    @PostMapping("/add/form-data")
    public MyResponse addScheduleTaskForm(@Validated ScheduleJobDto scheduleTaskVo) {
        scheduleService.addScheduleJob(scheduleTaskVo);
        return MyResponse.success();
    }

    @Operation(
            summary = "添加定时任务--JSON",
            security = { @SecurityRequirement(name = "auth") }
    )
    @PostMapping("/add/json")
    public MyResponse addScheduleTaskJson(@io.swagger.v3.oas.annotations.parameters.RequestBody @RequestBody @Validated ScheduleJobDto scheduleTaskVo) {
        scheduleService.addScheduleJob(scheduleTaskVo);
        return MyResponse.success();
    }

    @Operation(
            summary = "删除定时任务",
            security = { @SecurityRequirement(name = "auth") },
            parameters =@Parameter(name = "id", description = "定时任务ID", in = ParameterIn.PATH, required = true)
    )
    @DeleteMapping("/{id}")
    public MyResponse deleteSpringScheduledTask(@PathVariable("id") Long id) {
        scheduleService.deleteScheduleJob(id);
        return MyResponse.success();
    }
}
