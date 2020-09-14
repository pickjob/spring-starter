package app.controller;

import app.model.MyResponse;
import app.model.dto.ValidationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
            summary = "校验是否输入为奇数",
            security = { @SecurityRequirement(name = "auth") }
    )
    @PostMapping
    private MyResponse isOdd(@io.swagger.v3.oas.annotations.parameters.RequestBody @RequestBody @Validated ValidationDto dto) {
        return MyResponse.success("通过校验");
    }
}
