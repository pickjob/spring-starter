package app.config;

import app.model.message.MessageDelegateAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author pickjob@126.com
 * @date 2019-08-13
 */
@Configuration
public class RedisConfiguration {
    private static final Logger logger = LogManager.getLogger(RedisConfiguration.class);

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory, MessageDelegateAdapter adapter) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(connectionFactory);
        redisMessageListenerContainer.addMessageListener(adapter, new PatternTopic("*"));
        return redisMessageListenerContainer;
    }
}
