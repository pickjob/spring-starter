package app.service.scheduled;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author pickjob@126.com
 * @time 2019-01-11
 */
@Service
public class ScheduledService {
    private static final Logger logger = LogManager.getLogger(ScheduledService.class);

    @Scheduled(fixedRate = 60 * 1000)
    public void scheduledTask() {
        logger.info("default scheduled task");
    }

    public void scheduledTask(String name) {
        logger.info("{} scheduled task", name);
    }
}
