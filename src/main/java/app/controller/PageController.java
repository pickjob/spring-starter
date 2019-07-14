package app.controller;

import app.dao.CustomerDao;
import app.entity.Customer;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/v1/page")
@RestController
public class PageController {
    private static final Logger logger = LogManager.getLogger(PageController.class);
    @Autowired private CustomerDao customerDao;

    @GetMapping()
    public IPage<Customer> queryCustomerPaging(Integer page, Integer size) {
        return customerDao.selectPage(new Page<>(page, size), null);
    }
}
