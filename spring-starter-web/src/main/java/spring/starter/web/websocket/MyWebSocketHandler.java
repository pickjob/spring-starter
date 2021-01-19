package spring.starter.web.websocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: pickjob@126.com
 * @date: 2020-08-08
 **/
@Service
public class MyWebSocketHandler extends TextWebSocketHandler {
    private static final Logger logger = LogManager.getLogger(MyWebSocketHandler.class);
    private static final Object VALUE = new Object();
    private final ConcurrentHashMap<WebSocketSession, Object> container = new ConcurrentHashMap<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        logger.info("{}", message);
        WebSocketMessage<String> respMsg = new TextMessage(message.getPayload());
        for (WebSocketSession s : container.keySet()) {
            s.sendMessage(respMsg);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        logger.info("joining ip: {}", session.getRemoteAddress().getHostString());
        container.put(session, VALUE);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        logger.info("leaving ip: {}", session.getRemoteAddress().getHostString());
        container.remove(session);
    }
}
