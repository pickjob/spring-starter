package spring.starter.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import spring.starter.base.consts.SecurityConsts;
import spring.starter.base.model.MyResponse;


/**
 * @author pickjob@126.com
 * @date 2019-02-21
 */
@Tag(name = "文件上传示例")
@RequestMapping("/v1/upload")
@RestController
public class UploadController {
    private static final Logger logger = LogManager.getLogger(UploadController.class);

    @Operation(
            summary = "上传文件"
    )
    @RequiresPermissions(SecurityConsts.PERMISSION_UPLOAD)
    @PostMapping(consumes = "multipart/form-data")
    public MyResponse uploadFile(MultipartFile file) {
        logger.info("fileName: {}", file.getOriginalFilename());
        return MyResponse.success();
    }
}
