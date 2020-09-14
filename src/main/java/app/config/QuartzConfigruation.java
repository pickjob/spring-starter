package app.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author pickjob@126.com
 * @date 2019-02-21
 */
@Configuration
public class QuartzConfigruation {
    private static final Logger logger = LogManager.getLogger(QuartzConfigruation.class);

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("datasourceQuartz") DataSource dataSource) {
        Properties prop = new Properties();
        prop.put("org.quartz.scheduler.instanceName", "QuartzScheduler");
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "5");
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        prop.put("org.quartz.jobStore.isClustered", "true");
        prop.put("org.quartz.jobStore.clusterCheckinInterval", "15000");
        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");
        prop.put("org.quartz.jobStore.misfireThreshold", "12000");
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS WHERE LOCK_NAME = ? FOR UPDATE");
        prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setSchedulerName("QuartzScheduler");
        factory.setQuartzProperties(prop);
        factory.setDataSource(dataSource);
        factory.setStartupDelay(30);
        factory.setOverwriteExistingJobs(true);
        factory.setAutoStartup(true);
        return factory;
    }
}
