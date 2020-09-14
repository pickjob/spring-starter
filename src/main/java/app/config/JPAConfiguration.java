package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *   类创建参考: HibernateJpaConfiguration
 *   hibernate配置: AvailableSettings
 */
@EnableJpaRepositories(
        basePackages = "app.repository"
)
@Configuration
class JPAConfiguration {
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        return transactionManager;
    }
}