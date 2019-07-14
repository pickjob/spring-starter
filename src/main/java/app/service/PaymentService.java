package app.service;

import app.aop.datasource.annotation.DataSourceKey;
import app.aop.datasource.keys.DataSourceKeyEnum;
import app.dao.PaymentDao;
import app.entity.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-02-22
 */
@Service
public class PaymentService {
    private static Logger logger = LogManager.getLogger(PaymentService.class);
    @Autowired private PaymentDao paymentDao;

    public List<Payment> listAllPayments() {
        return paymentDao.selectList(null);
    }
}
