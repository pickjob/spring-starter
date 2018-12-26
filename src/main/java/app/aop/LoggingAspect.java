package app.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author pickjob@126.com
 * @time 2018-12-26
 */
@Component
@Aspect
public class LoggingAspect {
    private static Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("execution(public * app.controller..*(..))")
    private void loggingPointcut() {}

    @Around("app.aop.LoggingAspect.loggingPointcut()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        String id = UUID.randomUUID().toString();
        logger.info("{} entering {} {}", id, pjp.toLongString());
        Object retVal = pjp.proceed();
        logger.info("{} leaving", id);
        return retVal;
    }

}
