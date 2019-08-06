package app.controller;

import app.model.MyResponse;
import app.model.vo.PersonVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/v1/validation")
@RestController
public class ValidationController {
    private static Logger logger = LogManager.getLogger(ValidationController.class);

    @GetMapping
    private MyResponse validateEmail(@Valid PersonVo personVo
//            , BindingResult bindingResult
    ) {
//        logger.info("{}", bindingResult.getFieldError());
        return MyResponse.success();
    }
}
