package spring.starter.base.consts;

/**
 * @Author ws@yuan-mai.com
 * @Date 2020-11-02
 */
public interface RocketmqConst {
    static final String COMMON_TOPIC = "SPRING-STARTER-MESSAGE-ROCKETMQ";

    static final String MSG_TRACE_TOPIC = "MSG_TRACE_TOPIC";

    static final String MSG_TRACE_TOPIC_CONSUMER_GROUP = "MSG_TRACE_TOPIC_CONSUMER_GROUP";

    static final String COMMON_TAG = "COMMON";

    static final String COMMON_CONSUMER_GROUP = "COMMON_CONSUMER_GROUP";

    static final String MESSAGE_EX_CONSUMER_GROUP = "MESSAGE_EX_CONSUMER_GROUP";

    static final String TRANSACTION_TAG = "TRANSACTION";

    static final String TRANSACTION_CONSUMER_GROUP = "TRANSACTION_CONSUMER_GROUP";
}
