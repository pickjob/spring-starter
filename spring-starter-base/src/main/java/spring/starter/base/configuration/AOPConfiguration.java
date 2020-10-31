package spring.starter.base.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author pickjob@126.com
 * @date 2018-12-26
 */
@EnableAspectJAutoProxy(
        proxyTargetClass = true,
        exposeProxy = true  // 实现代理类自我调用仍然拦截方法
)
@Configuration
public class AOPConfiguration {
    private static final Logger logger = LogManager.getLogger(AOPConfiguration.class);

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        // Advisor代理构造类, 默认使用jdk接口代理, 会出问题, 如此兼容
        // 主要是用于Shiro注解拦截
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setUsePrefix(true);
        advisorAutoProxyCreator.setBeanName("spring.starter.web.controller");
        return advisorAutoProxyCreator;
    }
}
