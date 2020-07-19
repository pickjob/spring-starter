package app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author pickjob@126.com
 * @date 2019-01-11
 */
@Service
public class LoggerService {
    private static final Logger logger = LogManager.getLogger(LoggerService.class);

    public void log(String name) {
        logger.info("scheduled task, name: {}", name);
    }
}
