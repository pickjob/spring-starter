package app.service;

import app.aspect.datasource.DataSourceKey;
import app.dao.WhoAmIDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pickjob@126.com
 * @date 2020-05-10
 */
@Service
public class WhoAmIService {
    private static final Logger logger = LogManager.getLogger(WhoAmIService.class);
    @Autowired private WhoAmIDao whoAmIDao;

    @DataSourceKey(DataSourceKey.DataSourceKeyEnum.PRIMARY)
    public void showPrimary() {
        showWhoAmI();
    }

    @DataSourceKey(DataSourceKey.DataSourceKeyEnum.SECONDARY)
    public void showSecodary() {
        showWhoAmI();
    }

    private void showWhoAmI() {
        logger.info("db: {}", whoAmIDao.selectByPrimaryKey((byte)1).getName());
    }
}
