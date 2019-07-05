package app.service;

import app.dao.OrderDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Service
public class OrderService {
    private static final Logger logger = LogManager.getLogger(OrderService.class);
    @Autowired private OrderDao orderDao;

    public void  listAllOrders() {
        orderDao.selectList(null);
    }
}
