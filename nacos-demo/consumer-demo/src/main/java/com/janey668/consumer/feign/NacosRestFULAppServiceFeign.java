package com.janey668.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "producer-demo", fallbackFactory = NacosRestFULAppServiceFeignFallbackFactory.class)
public interface NacosRestFULAppServiceFeign {

    @GetMapping("/sayHello")
    String sayHello(@RequestParam("name") String name);


    @GetMapping("/test")
    String test(@RequestParam("name") String name);


}
