package app.service;

import app.common.annotation.DataSourceKey;
import app.common.keys.DataSourceKeyEnum;
import app.dao.PaymentDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pickjob@126.com
 * @time 2019-02-22
 */
@Service
public class PaymentService {
    private static Logger logger = LogManager.getLogger(PaymentService.class);
    @Autowired private PaymentDao paymentDao;

    public void listAllPayments() {
        paymentDao.selectList(null);
    }

    public void showRoutingDataSource() {
        // invoke seolf will not proxy !
        ((PaymentService) AopContext.currentProxy()).listAllPaymentsA();
        ((PaymentService) AopContext.currentProxy()).listAllPaymentsB();
    }

    @DataSourceKey(DataSourceKeyEnum.SCHEMA_A)
    public void listAllPaymentsA() {
        logger.info("listAllPaymentsA: {}", paymentDao.selectList(null));
    }

    @Transactional
    @DataSourceKey(DataSourceKeyEnum.SCHEMA_B)
    public void listAllPaymentsB() {
        logger.info("listAllPaymentsB: {}", paymentDao.selectList(null));
    }
}
