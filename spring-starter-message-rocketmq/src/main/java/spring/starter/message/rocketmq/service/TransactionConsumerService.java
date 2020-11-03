package spring.starter.message.rocketmq.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @Author pickjob@126.com
 * @Date 2020-11-02
 */
@RocketMQTransactionListener
@Service
public class TransactionConsumerService implements RocketMQLocalTransactionListener {
    private static final Logger logger = LogManager.getLogger(TransactionConsumerService.class);

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        // ... local transaction process, return bollback, commit or unknown
        logger.info("executeLocalTransaction message: {}", msg);
        return RocketMQLocalTransactionState.UNKNOWN;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        // ... check transaction status and return bollback, commit or unknown
        logger.info("checkLocalTransaction message: {}", msg);
        return RocketMQLocalTransactionState.COMMIT;
    }
}
