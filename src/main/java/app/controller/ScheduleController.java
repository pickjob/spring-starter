package app.controller;

import app.model.MyResponse;
import app.model.dto.ScheduleJobDto;
import app.service.schedule.ScheduleService;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "定时任务示例")
@RequestMapping("/v1/schedule")
@RestController
public class ScheduleController {
    private static final Logger logger = LogManager.getLogger(ScheduleController.class);
    @Autowired private ScheduleService scheduleService;

    @ApiOperation("添加定时任务--表单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "targetName", value = "目标Bean名称", defaultValue = "loggerService", required = true),
            @ApiImplicitParam(name = "targetMethod", value = "目标Bean方法", defaultValue = "log", required = true),
            @ApiImplicitParam(name = "targetArguement", value = "目标Bean方法参数", defaultValue = "arg", required = true),
            @ApiImplicitParam(name = "expression", value = "cron表达式", defaultValue = "* * * * * *", required = true),
            @ApiImplicitParam(name = "scheduleTypeEnum", value = "定时任务执行器 1-Spring, 2-Quartz", defaultValue = "1", allowableValues = "1,2", required = true),
            @ApiImplicitParam(name = "remark", value = "备注")
    })
    @PostMapping("/add/form-data")
    public MyResponse addScheduleTaskForm(@Validated ScheduleJobDto scheduleTaskVo) {
        scheduleService.addScheduleJob(scheduleTaskVo);
        return MyResponse.success();
    }

    @ApiOperation("添加定时任务--JSON")
    @PostMapping("/add/json")
    public MyResponse addScheduleTaskJson(@RequestBody @Validated ScheduleJobDto scheduleTaskVo) {
        scheduleService.addScheduleJob(scheduleTaskVo);
        return MyResponse.success();
    }

    @ApiOperation("删除定时任务")
    @DeleteMapping("/{id}")
    public MyResponse deleteSpringScheduledTask(@PathVariable("id") Long id) {
        scheduleService.deleteScheduleJob(id);
        return MyResponse.success();
    }
}
