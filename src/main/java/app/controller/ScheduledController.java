package app.controller;

import app.model.MyResponse;
import app.model.vo.ScheduledTaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
@RequestMapping("/v1/scheduled")
public class ScheduledController {

    @Autowired private TaskScheduler taskScheduler;
    @Autowired private ApplicationContext applicationContext;

    @PostMapping("/spring")
    public MyResponse createSpringScheduledTask(@RequestBody ScheduledTaskVo scheduledTaskVo) {
        taskScheduler.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Object targetObject = applicationContext.getBean(scheduledTaskVo.getTargetName());
                    String targetMethod = scheduledTaskVo.getTargetMethod();
                    String targetArguement = scheduledTaskVo.getTargetArguement();
                    Method method = targetObject.getClass().getMethod(targetMethod, String.class);
                    method.setAccessible(true);
                    method.invoke(targetObject, targetArguement);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new CronTrigger(scheduledTaskVo.getExpression()));
        return MyResponse.success();
    }
}
