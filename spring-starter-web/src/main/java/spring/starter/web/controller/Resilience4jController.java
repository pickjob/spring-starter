package spring.starter.web.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.starter.base.model.MyResponse;

/**
 * @Author pickjob@126.com
 * @Date 2021-01-26
 */
@Tag(name = "Resilience4j示例, 切面顺序  Retry ( CircuitBreaker ( RateLimiter ( TimeLimiter ( Bulkhead ( Function ) ) ) ) ) ")
@RequestMapping("/v1/resilience4j")
@RestController
public class Resilience4jController {
    private static final Logger logger = LogManager.getLogger(Resilience4jController.class);
    private static final String FALL_BACK_MSG = "fall back msg";

    @RateLimiter(name = "myRateLimiter", fallbackMethod = "fallbackMethod")
    @GetMapping("/rate-limiter")
    public MyResponse rateLimiter() {
        logger.info("something run");
        return MyResponse.success("Success");
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackMethod")
    @GetMapping("/circuit-breaker-when-error")
    public MyResponse circuitBreakerWithError() {
        logger.info("circuitBreaker when error happen");
        throw new RuntimeException("Some things go wrong ...");
    }

    @Retry(name = "myRetry", fallbackMethod = "fallbackMethod")
    @GetMapping("/retry-when-error")
    public MyResponse retryWithError() {
        logger.info("retry when error happen");
        throw new RuntimeException("Some things go wrong ...");
    }


    public MyResponse fallbackMethod(Throwable throwable) {
        return MyResponse.error(FALL_BACK_MSG);
    }
}
