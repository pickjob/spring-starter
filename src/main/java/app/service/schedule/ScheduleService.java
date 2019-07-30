package app.service.schedule;

import app.StatusEnum;
import app.dao.ScheduleJobDao;
import app.entity.ScheduleJob;
import app.model.vo.ScheduleJobVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @author pickjob@126.com
 * @time 2019-07-30
 */
@Service
public class ScheduleService {
    private static final Logger logger = LogManager.getLogger(ScheduleService.class);
    private Map<Long, ScheduledFuture> scheduleJobMap = new ConcurrentHashMap<>();
    @Autowired private ApplicationContext applicationContext;
    @Autowired private TaskScheduler taskScheduler;
    @Autowired private ScheduleJobDao scheduleJobDao;

    @Transactional
    public void addScheduleJob(ScheduleJobVo scheduleJobVo) {
        ScheduleJob job = new ScheduleJob();
        job.setBeanName(scheduleJobVo.getTargetName());
        job.setBeanMethod(scheduleJobVo.getTargetMethod());
        job.setMethodParams(scheduleJobVo.getTargetArguement());
        job.setCronExpression(scheduleJobVo.getExpression());
        job.setStatus(StatusEnum.NORMAL.getValue());
        job.setType((byte) 1);
        job.setCreateTime(new Date());
        scheduleJobDao.insert(job);
        Long jobId = job.getJobId();
        CronTask task = new CronTask(new Runnable() {
            @Override
            public void run() {
                try {
                    Object targetObject = applicationContext.getBean(scheduleJobVo.getTargetName());
                    String targetMethod = scheduleJobVo.getTargetMethod();
                    String targetArguement = scheduleJobVo.getTargetArguement();
                    Method method = targetObject.getClass().getMethod(targetMethod, String.class);
                    method.setAccessible(true);
                    method.invoke(targetObject, targetArguement);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }, scheduleJobVo.getExpression());
        ScheduledFuture scheduledFuture = taskScheduler.schedule(task.getRunnable(), task.getTrigger());
        scheduleJobMap.put(jobId, scheduledFuture);
    }

    @Transactional
    public void deleteScheduleJob(Long id) {
        ScheduleJob job = scheduleJobDao.selectById(id);
        if (job != null) return;
        job.setStatus(StatusEnum.DELETED.getValue());
        ScheduledFuture future = scheduleJobMap.get(id);
        future.cancel(true);
        scheduleJobMap.remove(id);
    }
}
