package com.status204.nacosconsumer.controller;

import com.status204.nacosconsumer.feign.HelloApi;
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
public class ServiceController {

    @Autowired
    private HelloApi helloApi;

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String greet){
        return helloApi.sayHello(greet);
    }
}
