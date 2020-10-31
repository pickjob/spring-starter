package spring.starter.data.rdms.configuration;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author pickjob@126.com
 * @date 2019-02-21
 */
@MapperScan(
        basePackages = {"spring.starter.data.rdms.dao.primary"},
        sqlSessionFactoryRef = "primarySqlSessionFactory",
        sqlSessionTemplateRef = "primarySqlSessionTemplate"
)
@Configuration
public class MybatisPrimaryConfiguration extends MybatisAutoConfiguration {
    private static final Logger logger = LogManager.getLogger(MybatisPrimaryConfiguration.class);

    public MybatisPrimaryConfiguration(@Qualifier("primaryMybatisProperties") MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }

    @Bean
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("datasourcePrimary") DataSource dataSource) throws Exception {
        return super.sqlSessionFactory(dataSource);
    }

    @Bean
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return super.sqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("datasourcePrimary") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
