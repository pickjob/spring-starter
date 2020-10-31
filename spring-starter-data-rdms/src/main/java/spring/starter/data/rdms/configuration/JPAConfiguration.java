package spring.starter.data.rdms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *   类创建参考: HibernateJpaConfiguration
 *   hibernate配置: AvailableSettings
 */
@EnableJpaRepositories(
        basePackages = "spring.starter.data.rdms.repository"
)
@Configuration
class JPAConfiguration {

    @Primary
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        return jpaTransactionManager;
    }
}