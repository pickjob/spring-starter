package app.service;

import app.dao.OrderDetailDao;
import app.entity.OrderDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Service
public class OrderDetailService {
    private static final Logger logger = LogManager.getLogger(OrderDetailService.class);
    @Autowired private OrderDetailDao orderDetailDao;

    public List<OrderDetail> listAllOrderDetails() {
        return orderDetailDao.selectList(null);
    }
}
