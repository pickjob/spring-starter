package app.service;

import app.dao.ProductDao;
import app.entity.Product;
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
public class ProductService {
    private static final Logger logger = LogManager.getLogger(ProductLineService.class);
    @Autowired private ProductDao productDao;

    public List<Product> listAllProducts() {
        return productDao.selectList(null);
    }
}
