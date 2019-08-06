package app;

import app.common.SpringApplicationContextUtils;
import app.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(
        exclude = DataSourceAutoConfiguration.class
)
public class Application implements ApplicationRunner {
    private static Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        SpringApplicationContextUtils.setApplicationContext(applicationContext);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}
