package com.status204.nacosconsumer.hystrix;

import com.status204.nacosconsumer.feign.HelloApi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by status200 on 2019/11/17.
 */
@Component
public class HelloApiHystrix implements HelloApi {


    @Override
    public String sayHello(@RequestParam("greet") String greet) {
        return "the provider has crashed! service currently unavailable";
    }
}
