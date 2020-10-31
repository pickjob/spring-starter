package spring.starter.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.starter.base.consts.SecurityConsts;
import spring.starter.base.model.MyResponse;
import spring.starter.web.dto.ValidationDto;

/**
 * @author pickjob@126.com
 * @date 2019-02-21
 */
@Tag(name = "校验示例")
@RequestMapping("/v1/validation")
@RestController
public class ValidationController {
    private static Logger logger = LogManager.getLogger(ValidationController.class);

    @Operation(
            summary = "校验是否输入为奇数"
    )
    @RequiresPermissions(SecurityConsts.PERMISSION_VALIDATION)
    @PostMapping
    private MyResponse isOdd(@RequestBody @Validated ValidationDto dto) {
        return MyResponse.success("通过校验");
    }
}
