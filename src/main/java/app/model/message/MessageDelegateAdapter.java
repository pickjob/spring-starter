package app.model.message;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @author pickjob@126.com
 * @date 2019-08-13
 */
public abstract class MessageDelegateAdapter implements MessageListener {

    public abstract void delegateHandleMessage(String pattern, String channel, String message);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        delegateHandleMessage(new String(pattern), new String(message.getChannel()), new String(message.getBody()));
    }
}