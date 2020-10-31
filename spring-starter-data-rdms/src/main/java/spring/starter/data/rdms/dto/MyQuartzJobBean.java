package spring.starter.data.rdms.dto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import spring.starter.data.rdms.utils.ApplicationContextHolder;

import java.lang.reflect.Method;

/**
 * @author pickjob@126.com
 * @date 2019-08-01
 */
public class MyQuartzJobBean extends QuartzJobBean {
    private static final Logger logger = LogManager.getLogger(MyQuartzJobBean.class);
    private String targetBean;
    private String targetMethod;
    private String targetArgument;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            Object targetObject = ApplicationContextHolder.getApplicationContext().getBean(targetBean);
            Method method = targetObject.getClass().getMethod(targetMethod, String.class);
            method.setAccessible(true);
            method.invoke(targetObject, targetArgument);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public String getTargetBean() {
        return targetBean;
    }

    public void setTargetBean(String targetBean) {
        this.targetBean = targetBean;
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

    public String getTargetArgument() {
        return targetArgument;
    }

    public void setTargetArgument(String targetArgument) {
        this.targetArgument = targetArgument;
    }
}
