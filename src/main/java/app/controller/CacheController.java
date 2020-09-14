package app.controller;

import app.model.MyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pickjob@126.com
 * @date 2019-08-13
 */
@Tag(name = "缓存示例")
@RequestMapping("/v1/cache")
@RestController
public class CacheController {
    private static final Logger logger = LogManager.getLogger(CacheController.class);

    @Operation(
            summary = "自动缓存",
            security = { @SecurityRequirement(name = "auth") },
            parameters = @Parameter(name = "id", description = "缓存ID", in = ParameterIn.QUERY, required = true, example = "12")
    )
    @Cacheable(value = "demoCache", key = "#id")
    @GetMapping("/auto-cache")
    public MyResponse autoCache(Integer id) {
        logger.info("autoCache: {}", id);
        return MyResponse.success(createData(id));
    }

    @Operation(
            summary = "强制设置缓存",
            security = { @SecurityRequirement(name = "auth") },
            parameters = @Parameter(name = "id", description = "缓存ID", required = true, example = "12")
    )
    @CachePut(value = "demoCache", key = "#id")
    @PostMapping("/force-cache")
    public MyResponse forceCache(Integer id) {
        logger.info("forceCache: {}", id);
        return MyResponse.success(createData(id));
    }

    @Operation(
            summary = "删除缓存",
            security = { @SecurityRequirement(name = "auth") },
            parameters = @Parameter (name = "id", description="缓存ID", example = "12", required = true)
    )
    @CacheEvict(value = "demoCache", key = "#id")
    @DeleteMapping("/evict-cache")
    public MyResponse evictCache(Integer id) {
        logger.info("evictCache: {}", id);
        return MyResponse.success();
    }

    private Map<String, Object> createData(Integer id) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("time", System.currentTimeMillis());
        return data;
    }
}
