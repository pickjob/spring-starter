package app.service;

import app.dao.base.UserMapper;
import app.model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ws@yuan-mai.com
 * @Date 2020-09-01
 */
@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    @Autowired private UserMapper userMapper;

    @Transactional(rollbackFor = Throwable.class)
    public void showInOneTransactional() {
        User user = new User();
        user.setAccount("Hello");
        user.setPassword("world");
        userMapper.insert(user);
        // 即使一个事务内仍可以获取到自增主键， 如果回滚主键会缺失
        logger.info("userId: {}", user.getId());
        user.setAccount("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        user.setId(null);
        userMapper.insert(user);
    }
}
