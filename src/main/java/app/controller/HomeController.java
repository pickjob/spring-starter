package app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pickjob@126.com
 * @time 2019-04-28
 **/
@RestController
public class HomeController {

    @RequestMapping("/")
    public String hello() {
        return "Hello, World";
    }
}