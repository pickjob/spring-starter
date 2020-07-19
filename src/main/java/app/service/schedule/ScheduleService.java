package app.service.schedule;

import app.dao.ScheduleJobDao;
import app.enums.ScheduleStatusEnum;
import app.enums.ScheduleTypeEnum;
import app.model.entity.ScheduleJob;
import app.model.schedule.MyQuartzJobBean;
import app.model.dto.ScheduleJobDto;
import app.util.ApplicationContextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @author pickjob@126.com
 * @date 2019-07-30
 */
@Service
public class ScheduleService {
    private static final Logger logger = LogManager.getLogger(ScheduleService.class);
    private Map<Long, ScheduledFuture> scheduleJobMap = new ConcurrentHashMap<>();
    @Autowired private TaskScheduler taskScheduler;
    @Autowired private Scheduler scheduler;
    @Autowired private ScheduleJobDao scheduleJobDao;

    @Transactional(rollbackFor = Throwable.class)
    public void addScheduleJob(ScheduleJobDto scheduleJobVo) {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setTargetBean(scheduleJobVo.getTargetName());
        scheduleJob.setTargetMethod(scheduleJobVo.getTargetMethod());
        scheduleJob.setTargetArgument(scheduleJobVo.getTargetArguement());
        scheduleJob.setCronExpression(scheduleJobVo.getExpression());
        scheduleJob.setScheduleStatus(ScheduleStatusEnum.NORMAL);
        scheduleJob.setScheduleType(scheduleJobVo.getScheduleTypeEnum());
        scheduleJob.setCreateTime(new Date());
        scheduleJobDao.insert(scheduleJob);
        Long scheduleJobId = scheduleJob.getId();
        if (scheduleJobVo.getScheduleTypeEnum() == ScheduleTypeEnum.SPRING) {
            CronTask task = new CronTask(new Runnable() {
                @Override
                public void run() {
                    try {
                        Object targetObject = ApplicationContextHolder.getApplicationContext().getBean(scheduleJobVo.getTargetName());
                        String targetMethod = scheduleJobVo.getTargetMethod();
                        String targetArgument = scheduleJobVo.getTargetArguement();
                        Method method = targetObject.getClass().getMethod(targetMethod, String.class);
                        method.setAccessible(true);
                        method.invoke(targetObject, targetArgument);
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }, scheduleJobVo.getExpression());
            ScheduledFuture scheduledFuture = taskScheduler.schedule(task.getRunnable(), task.getTrigger());
            scheduleJobMap.put(scheduleJobId, scheduledFuture);
        } else if (scheduleJobVo.getScheduleTypeEnum() == ScheduleTypeEnum.QUARTZ) {
            JobDetail jobDetail = JobBuilder
                                    .newJob(MyQuartzJobBean.class)
                                    .withIdentity(scheduleJobId + "")
                                    .build();
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                                                    .cronSchedule(scheduleJobVo.getExpression())
                                                    .withMisfireHandlingInstructionDoNothing();
            CronTrigger trigger = TriggerBuilder
                                    .newTrigger()
                                    .withIdentity(scheduleJobId + "")
                                    .withSchedule(scheduleBuilder)
                                    .build();
            JobDataMap dataMap = jobDetail.getJobDataMap();
            dataMap.put("targetBean", scheduleJobVo.getTargetName());
            dataMap.put("targetMethod", scheduleJobVo.getTargetMethod());
            dataMap.put("targetArgument", scheduleJobVo.getTargetArguement());
            try {
                scheduler.scheduleJob(jobDetail, trigger);
            } catch (SchedulerException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    public void deleteScheduleJob(Long scheduleJobId) {
        ScheduleJob job = scheduleJobDao.selectByPrimaryKey(scheduleJobId);
        if (job != null) return;
        job.setScheduleStatus(ScheduleStatusEnum.DELETED);
        if (job.getScheduleType() == ScheduleTypeEnum.SPRING) {
            ScheduledFuture future = scheduleJobMap.get(scheduleJobId);
            future.cancel(true);
            scheduleJobMap.remove(scheduleJobId);
        } else if (job.getScheduleType() == ScheduleTypeEnum.QUARTZ) {
            try {
                scheduler.unscheduleJob(new TriggerKey(scheduleJobId + ""));
            } catch (SchedulerException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
