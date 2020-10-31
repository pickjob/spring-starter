package spring.starter.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author pickjob@126.com
 * @date 2020-10-29
 */
@SpringBootApplication(
        scanBasePackages = {
                "spring.starter.base",
                "spring.starter.web"
        }
)
public class SpringWebApplication implements ApplicationRunner {
    private static Logger logger = LogManager.getLogger(SpringWebApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringWebApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Spring web is running");
    }
}
