package app.config;

import app.common.converter.DateConverter;
import app.common.converter.ScheduleTypeParser;
import app.filter.MyFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import java.util.Arrays;
import java.util.EnumSet;

//@EnableWebMvc
@Configuration
public class MVCConfiguration implements WebMvcConfigurer {
    private static final Logger logger = LogManager.getLogger(MVCConfiguration.class);

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
        registry.addParser(new ScheduleTypeParser());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/v1/**")
                .allowedOrigins("*")
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE", "PATCH")
                .allowCredentials(true).maxAge(3600)
                .allowedHeaders("Content-Type")
                ;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(MyFilter filter) {
        FilterRegistrationBean register = new FilterRegistrationBean();
        register.setFilter(filter);
        register.setUrlPatterns(Arrays.asList("/*"));
        register.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        return register;
    }
}
