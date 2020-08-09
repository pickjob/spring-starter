package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: pickjob@126.com
 * @date: 2020-07-21
 **/
@RequestMapping("/websocket")
@Controller
public class WebSocketViewController {

    @GetMapping
    public String index() {
        return "websocket/index";
    }
}
