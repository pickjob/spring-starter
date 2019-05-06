package app.service;

import app.dao.ProductDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Service
public class ProductService {
    private static final Logger logger = LogManager.getLogger(ProductLineService.class);
    @Autowired private ProductDao productDao;

    public void listAllProducts() {
        productDao.listAllProducts().forEach(p -> {
            logger.info("Product: {}", p);
        });
    }
}
