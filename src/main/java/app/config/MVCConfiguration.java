package app.config;

import app.type.converter.DateFormatter;
import app.type.converter.ScheduleTypeFormatter;
import app.filter.MyFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.EnumSet;
import java.util.List;

/**
 * @author pickjob@126.com
 * @date 2020-05-13
 */
//@EnableWebMvc
@Configuration
public class MVCConfiguration implements WebMvcConfigurer {
    private static final Logger logger = LogManager.getLogger(MVCConfiguration.class);

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter());
        registry.addFormatter(new ScheduleTypeFormatter());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/v1/**")
                .maxAge(3600)
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedHeaders("Authorization")
                ;
    }

    @Bean
    public MyFilter myFilter() {
        return new MyFilter();
    }

    @Bean
    public FilterRegistrationBean<Filter> myFilterRegistration() {
        FilterRegistrationBean<Filter> register = new FilterRegistrationBean<>();
        register.setFilter(myFilter());
        register.setUrlPatterns(List.of("/*"));
        register.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        register.setOrder(1);
        return register;
    }

    @Bean
    public FilterRegistrationBean<Filter> crosRegistration() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("Authorization");
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/v1/**", config);
        CorsFilter corsFilter = new CorsFilter(source);
        FilterRegistrationBean<Filter> register = new FilterRegistrationBean<>();
        register.setFilter(corsFilter);
        register.setUrlPatterns(List.of("/v1/**"));
        register.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        register.setOrder(2);
        return register;

    }
}
