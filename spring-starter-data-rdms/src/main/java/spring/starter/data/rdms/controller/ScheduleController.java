package spring.starter.data.rdms.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.starter.base.model.MyResponse;
import spring.starter.data.rdms.dto.ScheduleJobDto;
import spring.starter.data.rdms.service.ScheduleService;

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
            summary = "添加定时任务--表单"
    )
    @PostMapping(value = "/add/form-data", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public MyResponse addScheduleTaskForm(@Validated ScheduleJobDto scheduleTaskVo) {
        return MyResponse.success(scheduleService.addScheduleJob(scheduleTaskVo));
    }

    @Operation(
            summary = "添加定时任务--JSON"
    )
    @PostMapping("/add/json")
    public MyResponse addScheduleTaskJson(@RequestBody @Validated ScheduleJobDto scheduleTaskVo) {
        return MyResponse.success(scheduleService.addScheduleJob(scheduleTaskVo));
    }

    @Operation(
            summary = "删除定时任务",
            parameters =@Parameter(name = "id", description = "定时任务ID", in = ParameterIn.PATH, required = true)
    )
    @DeleteMapping("/{id}")
    public MyResponse deleteSpringScheduledTask(@PathVariable("id") Long id) {
        scheduleService.deleteScheduleJob(id);
        return MyResponse.success();
    }
}
