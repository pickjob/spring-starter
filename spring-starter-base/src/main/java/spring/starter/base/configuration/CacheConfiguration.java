package spring.starter.base.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author pickjob@126.com
 * @date 2019-08-13
 */
@EnableCaching(
        proxyTargetClass = true
)
@Configuration
public class CacheConfiguration
//        implements CachingConfigurer
{
    private static final Logger logger = LogManager.getLogger(CacheConfiguration.class);

}
