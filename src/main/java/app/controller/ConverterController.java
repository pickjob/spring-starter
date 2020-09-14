package app.controller;

import app.model.MyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

/**
 * @author pickjob@126.com
 * @date 2020-06-30
 */
@Tag (name = "转换示例")
@RequestMapping("/v1/converter")
@RestController
public class ConverterController {
    private static final Logger logger = LogManager.getLogger(ConverterController.class);

    @Operation(
            summary = "spring 参数-响应转换",
            security = { @SecurityRequirement(name = "auth") },
            parameters = @Parameter(name = "time", description = "待转换时间参数", in = ParameterIn.QUERY, required = true, example = "2020-06-01 12:00")
    )
    @PostMapping("/datetime")
    public MyResponse convertDatetime(Date time) {
        logger.info(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return MyResponse.success(calendar.getTime());
    }
}
