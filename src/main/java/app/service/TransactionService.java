package app.service;

import app.dao.primary.PrimaryWhoAmIDao;
import app.dao.secondary.SecondaryWhoAmIDao;
import app.model.entity.WhoAmI;
import app.repository.WhoAmIRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-01
 */
@Service
public class TransactionService {
    private static final Logger logger = LogManager.getLogger(TransactionService.class);
    private static final String SHORT_AND_INSERT_SUCCESS_NAME = "OneTransaction";
    private static final String LONG_AND_NEVER_INSERT_FAIL_NAME = "This is a long name, and nerver insert success";
    @Autowired private PrimaryWhoAmIDao primaryWhoAmIDao;
    @Autowired private SecondaryWhoAmIDao secondaryWhoAmIDao;
    @Autowired private WhoAmIRepository whoAmIRepository;
    @Autowired private WhoAmIService whoAmIService;

    @Transactional(rollbackFor = Throwable.class, transactionManager = "transactionManager")
    public void autoIncrementAndRallbackOneTransaction() {
        WhoAmI whoAmI = new WhoAmI();
        whoAmI.setName(SHORT_AND_INSERT_SUCCESS_NAME);
        whoAmIRepository.save(whoAmI);
        logger.info("whoAmI Id: {}", whoAmI.getId());
        whoAmI.setId(null);
        whoAmI.setName(LONG_AND_NEVER_INSERT_FAIL_NAME);
        whoAmIRepository.save(whoAmI);
        logger.info("whoAmI Id: {}", whoAmI.getId());
    }

    @Transactional(rollbackFor = Throwable.class, transactionManager = "transactionManager")
    public void dataSourceAopOneTransaction() {
        whoAmIService.showPrimary();
        whoAmIService.showSecodary();
    }

    @Transactional(rollbackFor = Throwable.class, transactionManager = "secondaryTransactionManager")
    public void multiDataSourceOneTransactionRollbackFail() {
        WhoAmI whoAmI = new WhoAmI();
        whoAmI.setName(SHORT_AND_INSERT_SUCCESS_NAME);
        primaryWhoAmIDao.insert(whoAmI);
        logger.info("whoAmI Id: {}", whoAmI.getId());
        whoAmI.setId(null);
        whoAmI.setName(LONG_AND_NEVER_INSERT_FAIL_NAME);
        secondaryWhoAmIDao.insert(whoAmI);
    }

    @Transactional(rollbackFor = Throwable.class, transactionManager = "chainedTransactionManager")
    public void multiDataSourceOneTransactionRollbackSuccess() {
        WhoAmI whoAmI = new WhoAmI();
        whoAmI.setName(SHORT_AND_INSERT_SUCCESS_NAME);
        primaryWhoAmIDao.insert(whoAmI);
        logger.info("whoAmI Id: {}", whoAmI.getId());
        whoAmI.setId(null);
        whoAmI.setName(LONG_AND_NEVER_INSERT_FAIL_NAME);
        secondaryWhoAmIDao.insert(whoAmI);
    }
}
