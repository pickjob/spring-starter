package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfigruation {

    @Bean
    public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
        factoryBean.setTargetBeanName("scheduledService");
        factoryBean.setTargetMethod("scheduledTask");
        factoryBean.setConcurrent(false);
        factoryBean.setArguments("quartz");
        return factoryBean;
    }

    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        factoryBean.setStartDelay(5000);
        factoryBean.setRepeatInterval(60 * 1000);
        return factoryBean;
    }
}
