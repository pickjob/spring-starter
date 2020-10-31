package spring.starter.data.rdms.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.starter.data.rdms.aspect.DataSourceKey;
import spring.starter.data.rdms.dto.MyQuartzJobBean;
import spring.starter.data.rdms.dto.ScheduleJobDto;
import spring.starter.data.rdms.entity.ScheduleJob;
import spring.starter.data.rdms.enums.ScheduleStatusEnum;
import spring.starter.data.rdms.enums.ScheduleTypeEnum;
import spring.starter.data.rdms.repository.ScheduleJobRepository;
import spring.starter.data.rdms.utils.ApplicationContextHolder;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
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
    @Autowired private ScheduleJobRepository scheduleJobRepository;

    @Transactional(rollbackFor = Throwable.class)
    @DataSourceKey(DataSourceKey.DataSourceKeyEnum.PRIMARY)
    public Long addScheduleJob(ScheduleJobDto scheduleJobVo) {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setTargetBean(scheduleJobVo.getTargetName());
        scheduleJob.setTargetMethod(scheduleJobVo.getTargetMethod());
        scheduleJob.setTargetArgument(scheduleJobVo.getTargetArguement());
        scheduleJob.setCronExpression(scheduleJobVo.getExpression());
        scheduleJob.setScheduleStatus(ScheduleStatusEnum.NORMAL);
        scheduleJob.setScheduleType(scheduleJobVo.getScheduleTypeEnum());
        scheduleJob.setCreateTime(new Date());
        scheduleJobRepository.save(scheduleJob);
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
        return scheduleJobId;
    }

    @Transactional(rollbackFor = Throwable.class, transactionManager = "transactionManager")
    @DataSourceKey(DataSourceKey.DataSourceKeyEnum.PRIMARY)
    public void deleteScheduleJob(Long scheduleJobId) {
        Optional<ScheduleJob> job = scheduleJobRepository.findById(scheduleJobId);
        if (job.isPresent()) {
            job.get().setScheduleStatus(ScheduleStatusEnum.DELETED);
            if (job.get().getScheduleType() == ScheduleTypeEnum.SPRING) {
                ScheduledFuture future = scheduleJobMap.get(scheduleJobId);
                future.cancel(true);
                scheduleJobMap.remove(scheduleJobId);
            } else if (job.get().getScheduleType() == ScheduleTypeEnum.QUARTZ) {
                try {
                    scheduler.unscheduleJob(new TriggerKey(scheduleJobId + ""));
                } catch (SchedulerException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }
}
