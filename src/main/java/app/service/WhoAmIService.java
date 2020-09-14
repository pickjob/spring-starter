package app.service;

import app.aspect.datasource.DataSourceKey;
import app.model.entity.WhoAmI;
import app.repository.WhoAmIRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author pickjob@126.com
 * @date 2020-05-10
 */
@Service
public class WhoAmIService {
    private static final Logger logger = LogManager.getLogger(WhoAmIService.class);
    @Autowired private WhoAmIRepository whoAmIRepository;

    @DataSourceKey(DataSourceKey.DataSourceKeyEnum.PRIMARY)
    public void showPrimary() {
        showWhoAmI();
    }

    @DataSourceKey(DataSourceKey.DataSourceKeyEnum.SECONDARY)
    public void showSecodary() {
        showWhoAmI();
    }

    private void showWhoAmI() {
        Optional<WhoAmI> whoAmI = whoAmIRepository.findById((byte)1);
        whoAmI.ifPresent(amI -> logger.info("db: {}", amI.getName()));
    }
}
