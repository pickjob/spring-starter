package app.config;

import app.config.socket.MyWebSocketHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@EnableWebSocket
@Configuration
public class WebSocketConfiguration implements WebSocketConfigurer {
    private static final Logger logger = LogManager.getLogger(WebSocketConfiguration.class);
    @Autowired MyWebSocketHandler myWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler, "/websocket/chat")
                .addInterceptors(new HttpSessionHandshakeInterceptor());;
    }

//    支持@ServerEndpoint配置
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }

//    Tomcat, WildFly, and GlassFish 配置
//    @Bean
//    public ServletServerContainerFactoryBean createWebSocketContainer() {
//        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
//        container.setMaxTextMessageBufferSize(8192);
//        container.setMaxBinaryMessageBufferSize(8192);
//        return container;
//    }

//    Jetty 配置
//    @Bean
//    public DefaultHandshakeHandler handshakeHandler() {
//        WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
//        policy.setInputBufferSize(8192);
//        policy.setIdleTimeout(600000);
//        return new DefaultHandshakeHandler(
//                new JettyRequestUpgradeStrategy(new WebSocketServerFactory(policy)));
//    }

}
