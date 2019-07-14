package app.aop;

import app.aop.datasource.annotation.DataSourceKey;
import app.aop.datasource.keys.DataSourceKeyEnum;
import app.aop.datasource.holder.DataSourceHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


/**
 * @author pickjob@126.com
 * @time 2019-02-22
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    private static Logger logger = LogManager.getLogger(DataSourceAspect.class);

    @Around("@annotation(key)")
    public Object routingDataSource(ProceedingJoinPoint pjp, DataSourceKey key) throws Throwable {
        logger.info("routing datasource to {}", key.value());
        DataSourceHolder.setDataSourceKey(key.value());
        Object retVal = pjp.proceed();
        DataSourceHolder.setDataSourceKey(DataSourceKeyEnum.SCHEMA_A);
        return retVal;
    }

    @Override
    public int getOrder() { // 指定次序保证先于 @Transactional执行,否则,会锁定connection
        return 2;
    }
}
