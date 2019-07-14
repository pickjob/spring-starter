package app.controller;

import app.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/v1/validation")
@RestController
public class ValidationController {
    private static Logger logger = LogManager.getLogger(ValidationController.class);

    @GetMapping
    public Person validation(Person person) {
        return person;
    }
}
