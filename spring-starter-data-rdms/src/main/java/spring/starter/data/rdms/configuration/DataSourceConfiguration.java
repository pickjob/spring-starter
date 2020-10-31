package spring.starter.data.rdms.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.starter.data.rdms.aspect.DataSourceHolder;
import spring.starter.data.rdms.aspect.DataSourceKey;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pickjob@126.com
 * @date 2019-02-22
 */
@EnableTransactionManagement(
        proxyTargetClass = true
)
@Configuration
public class DataSourceConfiguration {
    private static final Logger logger = LogManager.getLogger(DataSourceConfiguration.class);

    @ConfigurationProperties(prefix = "datasource.schema-primary")
    @Bean
    public HikariDataSource datasourcePrimary() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setPoolName("SCHEMA_PRIMARY");
        return dataSource;
    }

    @ConfigurationProperties(prefix = "datasource.schema-secondary")
    @Bean
    public HikariDataSource datasourceSecondary() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setPoolName("SCHEMA_SECONDARY");
        return dataSource;
    }

    @Primary
    @Bean
    public DataSource dataSource() {
        AbstractRoutingDataSource datasource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return DataSourceHolder.getDataSourceKey();
            }
        };
        Map<Object, Object> map = new HashMap<>();
        map.put(DataSourceKey.DataSourceKeyEnum.PRIMARY, datasourcePrimary());
        map.put(DataSourceKey.DataSourceKeyEnum.SECONDARY, datasourceSecondary());
        datasource.setTargetDataSources(map);
        datasource.setDefaultTargetDataSource(datasourcePrimary());
        return datasource;
    }

    // Quartz 专用数据源
    @ConfigurationProperties(prefix = "datasource.schema-quartz")
    @Bean
    public HikariDataSource datasourceQuartz() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setPoolName("SCHEMA_QUARTZ");
        return dataSource;
    }
}
