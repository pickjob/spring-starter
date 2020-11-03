package spring.starter.message.rocketmq.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.starter.base.consts.RocketmqConst;
import spring.starter.base.model.MyResponse;
import spring.starter.message.rocketmq.dto.RocketmqDto;

import java.util.Map;

/**
 * @Author pickjob@126.com
 * @Date 2020-11-02
 */
@Tag(name = "Rocketmq消息示例")
@RequestMapping("/v1/rocketmq")
@RestController
public class RocketmqController {
    private static final Logger logger = LogManager.getLogger(RocketmqController.class);
    @Autowired private RocketMQTemplate rocketMQTemplate;

    @Operation(
            summary = "发布普通消息"
    )
    @PostMapping("/common-msg")
    public MyResponse publishMessage(@RequestBody RocketmqDto dto) {
        // send message synchronously
        rocketMQTemplate.convertAndSend(RocketmqConst.COMMON_TOPIC + ":" + RocketmqConst.COMMON_TAG, dto.getMsg(), Map.of(dto.getHeaderKey(), dto.getHeaderValue()));
        // send spring message
        Message<String> message = MessageBuilder
                .<String>withPayload(dto.getMsg())
                .setHeader(dto.getHeaderKey(), dto.getHeaderValue())
                .build();
        rocketMQTemplate.send(RocketmqConst.COMMON_TOPIC + ":" + RocketmqConst.COMMON_TAG, message);
        return MyResponse.success();
    }

    @Operation(
            summary = "发布事务消息"
    )
    @PostMapping("/transaction-msg")
    public MyResponse sendTransactionMessage(@RequestBody RocketmqDto dto) {
        // send transaction message
        Message<String> message = MessageBuilder
                .<String>withPayload(dto.getMsg())
                .setHeader(dto.getHeaderKey(), dto.getHeaderValue())
                .build();
        rocketMQTemplate.sendMessageInTransaction(RocketmqConst.COMMON_TOPIC + ":" + RocketmqConst.TRANSACTION_TAG, message, null);
        return MyResponse.success();
    }

    //send messgae asynchronously
//        rocketMQTemplate.asyncSend("test-topic-2", new OrderPaidEvent("T_001", new BigDecimal("88.00")), new SendCallback() {
//            @Override
//            public void onSuccess(SendResult var1) {
//                System.out.printf("async onSucess SendResult=%s %n", var1);
//            }
//
//            @Override
//            public void onException(Throwable var1) {
//                System.out.printf("async onException Throwable=%s %n", var1);
//            }
//
//        });
    //Send messages orderly
//        rocketMQTemplate.syncSendOrderly("orderly_topic",MessageBuilder.withPayload("Hello, World").build(),"hashkey");
}
