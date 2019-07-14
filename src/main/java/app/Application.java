package app;

import app.entity.Customer;
import app.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = DataSourceAutoConfiguration.class
)
public class Application implements ApplicationRunner {
    private static Logger logger = LogManager.getLogger(Application.class);
    @Autowired private PaymentService paymentService;
    @Autowired private OfficeService officeService;
    @Autowired private EmployeeService employeeService;
    @Autowired private OrderService orderService;
    @Autowired private ProductLineService productlineService;
    @Autowired private ProductService productService;
    @Autowired private OrderDetailService orderDetailService;
    @Autowired private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        customerService.listAllCustomers();
    }
}
