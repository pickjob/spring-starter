package spring.starter.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author pickjob@126.com
 * @Date 2020-10-29
 */
@Tag(name = "主页")
@RequestMapping("/")
@RestController
public class HomeController {
    private static final Logger logger = LogManager.getLogger(HomeController.class);
    private static final String ECHO_HELLO = "Hello world!";

    @GetMapping
    public String sayHello() {
        logger.info(ECHO_HELLO);
        return ECHO_HELLO;
    }
}
