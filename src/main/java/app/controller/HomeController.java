package app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pickjob@126.com
 * @time 2019-04-28
 **/
@RestController
public class HomeController {
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @RequestMapping("/")
    public String hello() {
        return "Hello, World";
    }
}