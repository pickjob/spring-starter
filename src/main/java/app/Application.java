package app;

import app.repository.UserRepository;
import app.service.WhoAmIService;
import app.util.ApplicationContextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * @author pickjob@126.com
 * @date 2019-08-03
 */
@SpringBootApplication(
        exclude = { DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class}
)
public class Application implements ApplicationRunner {
    private static Logger logger = LogManager.getLogger(Application.class);
    @Autowired private WhoAmIService whoAmIService;
    @Autowired private UserRepository userRepository;

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        ApplicationContextHolder.setApplicationContext(applicationContext);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Spring boot is running");
        whoAmIService.showPrimary();
        whoAmIService.showSecodary();
    }
}
