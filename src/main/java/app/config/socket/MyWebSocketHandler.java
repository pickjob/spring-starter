package app.config.socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author: pickjob@126.com
 * @date: 2020-08-08
 **/
@Service
public class MyWebSocketHandler extends TextWebSocketHandler {
    private static final Logger logger = LogManager.getLogger(MyWebSocketHandler.class);
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        logger.info("{}", message);
        WebSocketMessage<String> respMsg = new TextMessage("Hello " + message.getPayload());
        session.sendMessage(respMsg);
    }
}
