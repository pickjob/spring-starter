package app.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author pickjob@126.com
 * @time 2019-02-21
 */
@MapperScan(basePackages = "app.dao")
@Configuration
public class MybatisConfiguration {
    private static final Logger logger = LogManager.getLogger(MybatisConfiguration.class);

}
