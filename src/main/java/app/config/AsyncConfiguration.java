package app.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.reflect.Method;

@EnableAsync(
        proxyTargetClass = true
)
@Configuration
public class AsyncConfiguration implements AsyncConfigurer {
    private static final Logger logger = LogManager.getLogger(AsyncConfiguration.class);

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                logger.error("{} counter {}, params: {}", method.getDeclaredAnnotations(), ex.getMessage(), params);
                logger.error(ex.getMessage(), ex);
            }
        };
    }
}
