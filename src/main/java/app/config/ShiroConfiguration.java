package app.config;

import app.shiro.MyAuthenticationFilter;
import app.shiro.MyRealms;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.DispatcherType;

/**
 * @author pickjob@126.com
 * @time 2020-02-22
 */
@Configuration
public class ShiroConfiguration {
    private static final Logger logger = LogManager.getLogger(ShiroConfiguration.class);

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleException(UnauthenticatedException e) {
        logger.error(e.getMessage(), e);
    }

    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleException(AuthorizationException e) {
        logger.error(e.getMessage(), e);
    }

    @Bean
    public Realm realm() {
        Realm realm = new MyRealms();
        return realm;
    }

    @Bean
    public MyAuthenticationFilter myAuthenticationFilter() {
        return new MyAuthenticationFilter();
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/logout", "logout");
//        chainDefinition.addPathDefinition("/**", "myAuthen");
        return chainDefinition;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,
                                                         ShiroFilterChainDefinition shiroFilterChainDefinition,
                                                         MyAuthenticationFilter myAuthenticationFilter) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        filterFactoryBean.getFilters().put("myAuthen", myAuthenticationFilter);
        filterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition.getFilterChainMap());
        return filterFactoryBean;
    }

    @Bean
    public FilterRegistrationBean delegatingFilterProxy(ShiroFilterFactoryBean shiroFilterFactoryBean) throws Exception {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ERROR);
        filterRegistrationBean.setFilter((AbstractShiroFilter)shiroFilterFactoryBean.getObject());
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
