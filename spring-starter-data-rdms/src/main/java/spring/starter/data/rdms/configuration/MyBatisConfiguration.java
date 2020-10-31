package spring.starter.data.rdms.configuration;

import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.Properties;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-08
 */
@Configuration
public class MyBatisConfiguration {
    @Bean
    public MybatisProperties primaryMybatisProperties() {
        Properties properties = new Properties();
        properties.put("map-underscore-to-camel-case", true);
        MybatisProperties mybatisProperties = new MybatisProperties();
        mybatisProperties.setConfigurationProperties(properties);
        mybatisProperties.setTypeHandlersPackage("spring.starter.data.rdms.typehandler");
        mybatisProperties.setMapperLocations(new String[]{"classpath*:dao/base/**/*.xml", "classpath*:dao/primary/**/*.xml"});
        return mybatisProperties;
    }

    @Bean
    public MybatisProperties secondaryMybatisProperties() {
        Properties properties = new Properties();
        properties.put("map-underscore-to-camel-case", true);
        MybatisProperties mybatisProperties = new MybatisProperties();
        mybatisProperties.setConfigurationProperties(properties);
        mybatisProperties.setTypeHandlersPackage("spring.starter.data.rdms.typehandler");
        mybatisProperties.setMapperLocations(new String[]{"classpath*:dao/base/**/*.xml", "classpath*:dao/secondary/**/*.xml"});
        return mybatisProperties;
    }

    @Bean
    public ChainedTransactionManager chainedTransactionManager(@Qualifier("primaryTransactionManager") DataSourceTransactionManager primaryTransactionManager,
                                                               @Qualifier("secondaryTransactionManager") DataSourceTransactionManager secondaryTransactionManager) {
        return new ChainedTransactionManager(primaryTransactionManager, secondaryTransactionManager);
    }
}
