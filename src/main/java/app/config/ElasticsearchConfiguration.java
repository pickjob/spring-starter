package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @Author ws@yuan-mai.com
 * @Date 2020-09-14
 */
@EnableElasticsearchRepositories(
        basePackages = "app.repository.elasticsearch"
)
@Configuration
public class ElasticsearchConfiguration {
}
