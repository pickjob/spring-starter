package spring.starter.message.rocketmq.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;
import spring.starter.base.consts.RocketmqConst;

/**
 * @Author pickjob@126.com
 * @Date 2020-11-02
 */
@RocketMQMessageListener(
        topic = RocketmqConst.COMMON_TOPIC,
        selectorExpression = RocketmqConst.COMMON_TAG,
        consumerGroup = RocketmqConst.COMMON_CONSUMER_GROUP
)
@Service
public class CommonConsumerService implements RocketMQListener<String> {
    private static final Logger logger = LogManager.getLogger(CommonConsumerService.class);

    @Override
    public void onMessage(String message) {
        logger.info("received message: {}", message);
    }
}
