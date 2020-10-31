package spring.starter.data.rdms.configuration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spring.starter.data.rdms.converter.ScheduleTypeFormatter;

/**
 * @author pickjob@126.com
 * @date 2020-05-13
 */
@EnableWebMvc
@Configuration
public class MVCConfiguration implements WebMvcConfigurer {
    private static final Logger logger = LogManager.getLogger(MVCConfiguration.class);

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new ScheduleTypeFormatter());
    }
}
