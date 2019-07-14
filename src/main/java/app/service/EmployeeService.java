package app.service;

import app.dao.EmployeeDao;
import app.entity.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-05-05
 **/
@Service
public class EmployeeService {
    private static final Logger logger = LogManager.getLogger(EmployeeService.class);
    @Autowired private EmployeeDao employeeDao;

    public List<Employee> listAllEmployees() {
        return employeeDao.selectList(null);
    }
}
