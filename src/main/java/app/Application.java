package app;

import app.common.SpringApplicationContextUtils;
import app.entity.document.AreaCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication(
        exclude = DataSourceAutoConfiguration.class
)
public class Application implements ApplicationRunner {
    private static Logger logger = LogManager.getLogger(Application.class);
    @Autowired private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        SpringApplicationContextUtils.setApplicationContext(applicationContext);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Query query = new Query();
        mongoTemplate.find(query, AreaCode.class).forEach(log -> {
            logger.info("log: {}", log);
        });
    }
}
