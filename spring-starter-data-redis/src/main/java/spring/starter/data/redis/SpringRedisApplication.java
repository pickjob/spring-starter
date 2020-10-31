package spring.starter.data.redis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author pickjob@126.com
 * @Date 2020-10-30
 */
@SpringBootApplication(
        scanBasePackages = {
                "spring.starter.base",
                "spring.starter.data.redis"
        }
)
public class SpringRedisApplication implements CommandLineRunner {
        private static final Logger logger = LogManager.getLogger(SpringRedisApplication.class);

        public static void main(String[] args) {
                SpringApplication.run(SpringRedisApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {
                logger.info("redis is running ...");
        }
}
