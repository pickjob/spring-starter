package app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pickjob@126.com
 * @date 2019-04-28
 **/
@Tag(name = "根目录示例")
@RequestMapping("/v1")
@RestController
public class HomeController {
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @Operation(
            summary = "根目录接口"
    )
    @GetMapping("/")
    public String home() {
        return "Hello, World";
    }
}