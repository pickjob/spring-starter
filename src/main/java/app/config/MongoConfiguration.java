package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author ws@yuan-mai.com
 * @Date 2020-09-14
 */
@EnableMongoRepositories(
        basePackages = "app.repository.mongo"
)
@Configuration
public class MongoConfiguration {
}
