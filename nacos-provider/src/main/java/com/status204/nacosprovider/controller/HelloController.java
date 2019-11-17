package com.status204.nacosprovider.controller;

import com.status204.nacosprovider.config.ConfigProperties;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by status200 on 2019/11/17.
 */

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @Autowired
    private ConfigProperties properties;

    @GetMapping("sayHello")
    public String sayHello(@RequestParam String greet) {
        log.info("greet received {}", greet);
        return "Hello world from: " + properties.getLocalID();
    }
}
