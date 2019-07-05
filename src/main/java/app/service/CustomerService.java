package app.service;

import app.dao.CustomerDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pickjob@126.com
 * @time 2019-05-29
 */
@Service
public class CustomerService {
    private static final Logger logger = LogManager.getLogger(CustomerService.class);
    @Autowired private CustomerDao customerDao;

    public void listAllCustomers() {
        customerDao.selectList(null);
    }
}
