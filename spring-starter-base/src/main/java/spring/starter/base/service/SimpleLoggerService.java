package spring.starter.base.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author pickjob@126.com
 * @date 2019-01-11
 */
@Service
public class SimpleLoggerService {
    private static final Logger logger = LogManager.getLogger(SimpleLoggerService.class);

    public void log(String info) {
        logger.info("simpleLoggerService, info: {}", info);
    }
}
