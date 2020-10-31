package spring.starter.base.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author pickjob@126.com
 * @date 2018-12-26
 */
@Aspect
@Component
public class LoggingAspect implements Ordered {
    private static Logger logger = LogManager.getLogger(LoggingAspect.class);
    @Autowired private ObjectMapper objectMapper;

    @Around("execution(public * spring.starter..controller..*(..))")
    public Object accessLogging(ProceedingJoinPoint pjp) throws Throwable {
        String id = UUID.randomUUID().toString();
        List<String> args = new ArrayList<>();
        for (Object arg : pjp.getArgs()) {
            if (!(arg instanceof MultipartFile)) {
                args.add(objectMapper.writeValueAsString(arg));
            }
        }
        logger.info("entering: {}, param: {} ({})", pjp.toLongString(), args, id);
        Object retVal = pjp.proceed();
        logger.info("leaving: {} ({})", pjp.toLongString(), id);
        return retVal;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
