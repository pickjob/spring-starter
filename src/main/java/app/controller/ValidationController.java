package app.controller;

import app.model.MyResponse;
import app.model.dto.ValidationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "校验示例")
@RequestMapping("/v1/validation")
@RestController
public class ValidationController {
    private static Logger logger = LogManager.getLogger(ValidationController.class);

    @ApiOperation("校验是否输入为奇数")
    @ApiImplicitParam(name = "number", value = "待校验数", defaultValue = "34", paramType = "query", required = true)
    @GetMapping
    private MyResponse isOdd(@Validated ValidationDto dto) {
        return MyResponse.success();
    }
}
