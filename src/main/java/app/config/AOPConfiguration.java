package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author pickjob@126.com
 * @time 2018-12-26
 */
@Configuration
@EnableAspectJAutoProxy(
        proxyTargetClass = true,
        exposeProxy = true  // 实现代理类自我调用仍然拦截方法
)
public class AOPConfiguration {
}
