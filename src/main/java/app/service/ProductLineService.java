package app.service;

import app.dao.ProductLineDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Service
public class ProductLineService {
    private static final Logger logger = LogManager.getLogger(ProductLineService.class);
    @Autowired private ProductLineDao productlineDao;

    public void listAllProductlines() {
        productlineDao.listAllProductlines().forEach(p -> {
            logger.info("ProductLine: {}", p);
        });
    }
}
