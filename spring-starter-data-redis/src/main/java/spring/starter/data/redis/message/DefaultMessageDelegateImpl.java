package spring.starter.data.redis.message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-09
 */
@Service
public class DefaultMessageDelegateImpl extends MessageDelegateAdapter {
    private static final Logger logger = LogManager.getLogger(DefaultMessageDelegateImpl.class);

    @Override
    public void delegateHandleMessage(String pattern, String channel, String message) {
        logger.info("pattern: {}, channel: {}, message: {}", pattern, channel, message);
    }
}
