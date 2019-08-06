package app.common;

import org.springframework.context.ApplicationContext;

/**
 * @author pickjob@126.com
 * @time 2019-08-01
 */
public class SpringApplicationContextUtils {
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringApplicationContextUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
