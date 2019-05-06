package app.config;

import app.common.keys.DataSourceKeyEnum;
import app.util.DataSourceHolder;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pickjob@126.com
 * @time 2019-02-22
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "datasource.schema-a")
    public HikariDataSource dataSourceA() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setPoolName("SCHEMA_A");
        return dataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.schema-b")
    public HikariDataSource dataSourceB() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setPoolName("SCHEMA_B");
        return dataSource;
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        AbstractRoutingDataSource dataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return DataSourceHolder.getDataSourceKey();
            }
        };
        Map<Object, Object> map = new HashMap<>();
        map.put(DataSourceKeyEnum.SCHEMA_A, dataSourceA());
        map.put(DataSourceKeyEnum.SCHEMA_B, dataSourceB());
        dataSource.setTargetDataSources(map);
        dataSource.setDefaultTargetDataSource(dataSourceA());
        return dataSource;
    }
}
