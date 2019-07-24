package app.controller;

import app.model.MyResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    private static final Logger logger = LogManager.getLogger(UploadController.class);

    @PostMapping("/v1/upload")
    public MyResponse uploadFile(MultipartFile file) {
        logger.info("fileName: {}", file.getOriginalFilename());
        return MyResponse.success();
    }
}
