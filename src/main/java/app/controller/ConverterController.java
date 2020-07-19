package app.controller;

import app.model.MyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "转换示例")
@RequestMapping("/v1/converter")
@RestController
public class ConverterController {
    private static final Logger logger = LogManager.getLogger(ConverterController.class);

    @ApiOperation("spring 参数-响应转换")
    @ApiImplicitParam(name = "time", value = "待转换时间参数", defaultValue = "2020-06-01 12:00", required = true)
    @PostMapping("/datetime")
    public MyResponse convertDatetime(Date time) {
        logger.info(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return MyResponse.success(calendar.getTime());
    }
}
