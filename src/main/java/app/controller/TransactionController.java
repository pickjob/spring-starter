package app.controller;

import app.model.MyResponse;
import app.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ws@yuan-mai.com
 * @Date 2020-09-01
 */
@Api(tags = "同一事务情况")
@RequestMapping("/v1/transaction")
@RestController
public class TransactionController {
    @Autowired UserService userService;

    @GetMapping("/throw-exception")
    public MyResponse throwException() {
        userService.showInOneTransactional();
        return MyResponse.success();
    }
}
