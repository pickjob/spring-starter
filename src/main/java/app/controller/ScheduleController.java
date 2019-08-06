package app.controller;

import app.common.ScheduleTypeEnum;
import app.model.MyResponse;
import app.model.vo.ScheduleJobVo;
import app.service.schedule.ScheduleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/schedule")
public class ScheduleController {
    private static final Logger logger = LogManager.getLogger(ScheduleController.class);
    @Autowired private ScheduleService scheduleService;

    @PostMapping("/spring")
    public MyResponse createSpringScheduleTask(@RequestBody @Valid ScheduleJobVo scheduleTaskVo) {
        scheduleService.addScheduleJob(scheduleTaskVo, ScheduleTypeEnum.SPRING);
        return MyResponse.success();
    }

    @DeleteMapping("/spring/{id}")
    public MyResponse deleteSpringScheduledTask(@PathVariable("id") Long id) {
        scheduleService.deleteScheduleJob(id, ScheduleTypeEnum.SPRING);
        return MyResponse.success();
    }

    @PostMapping("/quartz")
    public MyResponse createQuartzScheduleTask(@RequestBody @Valid ScheduleJobVo scheduleTaskVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            logger.info("errors: {}", errors);
            return MyResponse.error();
        }
        scheduleService.addScheduleJob(scheduleTaskVo, ScheduleTypeEnum.QUARTZ);
        return MyResponse.success();
    }

    @DeleteMapping("/quartz/{id}")
    public MyResponse deleteQuartzScheduledTask(@PathVariable("id") Long id) {
        scheduleService.deleteScheduleJob(id, ScheduleTypeEnum.QUARTZ);
        return MyResponse.success();
    }
}
