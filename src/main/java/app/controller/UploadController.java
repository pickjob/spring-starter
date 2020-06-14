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
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "文件上传示例")
@RequestMapping("/v1/upload")
@RestController
public class UploadController {
    private static final Logger logger = LogManager.getLogger(UploadController.class);

    @ApiOperation("上传文件")
    @ApiImplicitParam( name = "file", value = "待上传文件", dataType = "__file", paramType = "form", required = true)
    @PostMapping
    public MyResponse uploadFile(MultipartFile file) {
        logger.info("fileName: {}", file.getOriginalFilename());
        return MyResponse.success();
    }
}
