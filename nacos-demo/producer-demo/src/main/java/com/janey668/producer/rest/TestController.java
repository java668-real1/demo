package com.janey668.producer.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {


    @GetMapping("/test")
    public String test(String name){
        System.out.println("provider controller name = " + name);
        int i = 1/0;
        return name;
    }

}
