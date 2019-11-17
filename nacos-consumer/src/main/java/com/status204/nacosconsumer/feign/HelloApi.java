package com.status204.nacosconsumer.feign;

import com.status204.nacosconsumer.hystrix.HelloApiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by status200 on 2019/11/17.
 */
@Component
@FeignClient(name="provider", fallback = HelloApiHystrix.class)
public interface HelloApi {

    @GetMapping("/hello/sayHello")
    String sayHello(@RequestParam("greet") String greet);
}
