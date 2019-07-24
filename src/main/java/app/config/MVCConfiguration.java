package app.config;

import app.converter.DateConverter;
import app.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import java.util.Arrays;
import java.util.EnumSet;

@Configuration
@EnableWebMvc
public class MVCConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateConverter dateConverter = new DateConverter();
        registry.addConverter(dateConverter);
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
