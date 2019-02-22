package app.service;

import app.common.annotation.DataSourceKey;
import app.common.keys.DataSourceKeyEnum;
import app.dao.StudentDao;
import app.entity.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author pickjob@126.com
 * @time 2019-02-22
 */
@Service
public class StudentService {
    private static Logger logger = LogManager.getLogger(StudentService.class);
    private StudentDao studentDao;

    public StudentService() {}

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void doSomething() {
        ((StudentService) AopContext.currentProxy()).queryStudentInfo(); // 调用自己方法拦截自己
        ((StudentService) AopContext.currentProxy()).createNewStudent();
    }

    @DataSourceKey(DataSourceKeyEnum.SCHEMA_B)
    public void queryStudentInfo() {
        studentDao.queryStudentInfo()
                .forEach(x -> {
                    logger.info(x);
                });
    }

    @Transactional
    @DataSourceKey(DataSourceKeyEnum.SCHEMA_A)
    public void createNewStudent() {
        Student student = new Student();
        student.setMatricNo("11311");
        student.setFirstName("firstName");
        student.setLastName("lastName");
        student.setDateOfBirth(new Date());
        studentDao.createNewStudentInfo(student);
    }
}
