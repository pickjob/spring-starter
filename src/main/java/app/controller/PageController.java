package app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/v1/page")
@RestController
public class PageController {
    private static final Logger logger = LogManager.getLogger(PageController.class);

}
