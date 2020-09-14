package app.controller;

import app.model.MyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-09
 */
@Tag( name = "Redis示例")
@RequestMapping("/v1/redis")
@RestController
public class RedisController {
    @Autowired private StringRedisTemplate redisTemplate;

    @Operation(
            summary = "redis 发布消息",
            security = { @SecurityRequirement(name = "auth") },
            parameters = {
                    @Parameter(name = "channel", description = "发布通道", in = ParameterIn.QUERY, required = true, example = "channel"),
                    @Parameter(name = "message", description = "发布消息", in = ParameterIn.QUERY, required = true, example = "channel")
            }
    )
    @GetMapping("/publish")
    public MyResponse publishMessage(String channel, String msg) {
        redisTemplate.convertAndSend(channel, msg);
        return MyResponse.success();
    }
}
