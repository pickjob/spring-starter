package app.controller;

import app.model.MyResponse;
import app.model.vo.ScheduleJobVo;
import app.service.schedule.ScheduleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/schedule")
public class ScheduleController {
    private static final Logger logger = LogManager.getLogger(ScheduleController.class);
    @Autowired private ScheduleService scheduleService;

    @PostMapping("/spring")
    public MyResponse createSpringScheduledTask(@RequestBody ScheduleJobVo scheduledTaskVo) {
        scheduleService.addScheduleJob(scheduledTaskVo);
        return MyResponse.success();
    }

    @DeleteMapping("/spring/{id}")
    public MyResponse deleteSpringScheduledTask(@PathVariable("id") Long id) {
        scheduleService.deleteScheduleJob(id);
        return MyResponse.success();
    }
}
