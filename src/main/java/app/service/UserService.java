package app.service;

import app.aspect.datasource.DataSourceKey;
import app.model.entity.User;
import app.repository.jpa.UserJpaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-07
 */
@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(TransactionService.class);
    @Autowired private UserJpaRepository userRepository;

    @DataSourceKey(DataSourceKey.DataSourceKeyEnum.PRIMARY)
    public void saveUserPrimary(User user) {
        userRepository.save(user);
    }

    @DataSourceKey(DataSourceKey.DataSourceKeyEnum.SECONDARY)
    public void saveUserSecondary(User user) {
        userRepository.save(user);
    }
}
