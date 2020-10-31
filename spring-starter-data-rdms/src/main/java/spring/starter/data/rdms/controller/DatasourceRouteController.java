package spring.starter.data.rdms.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.starter.base.model.MyResponse;
import spring.starter.data.rdms.entity.WhoAmI;
import spring.starter.data.rdms.service.WhoAmIService;

import java.util.Optional;

/**
 * @Author pickjob@126.com
 * @Date 2020-10-30
 */
@Tag(name = "数据源路由示例")
@RequestMapping("/v1/datasource-route")
@RestController
public class DatasourceRouteController {
    private static final Logger logger = LogManager.getLogger(DatasourceRouteController.class);
    @Autowired private WhoAmIService whoAmIService;

    @Operation(
            summary = "数据源切换",
            parameters = @Parameter(name = "sourceName", description = "数据源名称: PRIMARY, SECONDARY", in = ParameterIn.QUERY, required = true, example = "PRIMARY")
    )
    @GetMapping
    public MyResponse routeDatasource(String sourceName) {
        Optional<WhoAmI> result = null;
        if ("PRIMARY".equals(sourceName)) {
            result = whoAmIService.showPrimary();
        } else if ("SECONDARY".equals(sourceName)) {
            result = whoAmIService.showPrimary();
        }
        return MyResponse.success(result);
    }
}
