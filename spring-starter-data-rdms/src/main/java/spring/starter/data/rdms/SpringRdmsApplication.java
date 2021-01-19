package spring.starter.data.rdms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import spring.starter.data.rdms.utils.ApplicationContextHolder;

/**
 * @Author pickjob@126.com
 * @Date 2020-10-30
 */
@SpringBootApplication(
        scanBasePackages = {
                "spring.starter.base",
                "spring.starter.data.rdms"
        },
        exclude = {
                DataSourceAutoConfiguration.class,
                MybatisAutoConfiguration.class
        }
)
public class SpringRdmsApplication implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(SpringRdmsApplication.class);

    public static void main(String[] args) {
        ApplicationContextHolder.setApplicationContext(SpringApplication.run(SpringRdmsApplication.class, args));
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("rdms is running ...");
    }
}
