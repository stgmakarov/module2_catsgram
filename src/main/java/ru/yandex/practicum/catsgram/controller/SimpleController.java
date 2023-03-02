package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/home")
    //@RequestMapping(value = "/home", produces = "text/plain;charset=UTF-8")
    public String homePage() {
        log.debug("Получен запрос.");
        return "Котограм";
    }
}
