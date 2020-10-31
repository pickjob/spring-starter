package spring.starter.data.rdms.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.starter.data.rdms.aspect.DataSourceKey;
import spring.starter.data.rdms.entity.WhoAmI;
import spring.starter.data.rdms.repository.WhoAmIJpaRepository;

import java.util.Optional;

/**
 * @author pickjob@126.com
 * @date 2020-05-10
 */
@Service
public class WhoAmIService {
    private static final Logger logger = LogManager.getLogger(WhoAmIService.class);
    @Autowired private WhoAmIJpaRepository whoAmIRepository;

    public void show() {
        ((WhoAmIService) AopContext.currentProxy()).showPrimary();
        ((WhoAmIService) AopContext.currentProxy()).showSecodary();
    }

    @DataSourceKey(DataSourceKey.DataSourceKeyEnum.PRIMARY)
    public Optional<WhoAmI> showPrimary() {
        return showWhoAmI();
    }

    @DataSourceKey(DataSourceKey.DataSourceKeyEnum.SECONDARY)
    public Optional<WhoAmI> showSecodary() {
        return showWhoAmI();
    }

    @Transactional(rollbackFor = Throwable.class)
    private Optional<WhoAmI> showWhoAmI() {
        Optional<WhoAmI> whoAmI = whoAmIRepository.findById(1L);
        whoAmI.ifPresent(amI -> logger.info("db: {}", amI.getName()));
        return whoAmI;
    }
}
