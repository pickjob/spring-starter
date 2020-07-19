package app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pickjob@126.com
 * @date 2019-04-28
 **/
@Api(tags = "根目录示例")
@RequestMapping("/v1")
@RestController
public class HomeController {
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @ApiOperation("根目录接口")
    @GetMapping("/")
    public String home() {
        return "Hello, World";
    }
}