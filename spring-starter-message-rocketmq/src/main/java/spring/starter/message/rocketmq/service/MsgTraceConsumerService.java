package spring.starter.message.rocketmq.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.common.message.MessageExt;
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
        consumerGroup = RocketmqConst.MSG_TRACE_TOPIC_CONSUMER_GROUP,
        enableMsgTrace = true,
        customizedTraceTopic = RocketmqConst.MSG_TRACE_TOPIC
)
@Service
public class MsgTraceConsumerService implements RocketMQListener<MessageExt> {
    private static final Logger logger = LogManager.getLogger(MsgTraceConsumerService.class);

    @Override
    public void onMessage(MessageExt messageExt) {
        logger.info("trace msg: {}", messageExt);
    }
}
