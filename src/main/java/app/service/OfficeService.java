package app.service;

import app.dao.OfficeDao;
import app.entity.Office;
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
public class OfficeService {
    private static Logger logger = LogManager.getLogger(OfficeService.class);
    @Autowired private OfficeDao officeDao;

    public List<Office> listAllOffices() {
        return officeDao.selectList(null);
    }
}
