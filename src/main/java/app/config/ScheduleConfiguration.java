package app.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author pickjob@126.com
 * @time 2019-01-11
 */
@EnableScheduling
@Configuration
public class ScheduleConfiguration
//        implements SchedulingConfigurer
{
    private static final Logger logger = LogManager.getLogger(ScheduleConfiguration.class);

//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//    }
}
