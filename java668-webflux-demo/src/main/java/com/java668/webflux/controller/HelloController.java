package com.java668.webflux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    //普通方法
    @GetMapping("/hello")
    public String hello() {

        log.info("开始时间：" + System.currentTimeMillis());
        String result = createStr();
        log.info("结束时间：" + System.currentTimeMillis());
        return result;
    }

    // Mono方法
    @GetMapping("/mono")
    public Mono<String> mono() {
        log.info("开始时间：" + System.currentTimeMillis());
        Mono<String> result = Mono.fromSupplier(this::createStr);
        log.info("结束时间：" + System.currentTimeMillis());
        return result;
    }


    // 服务器推送(SSE - >Server Send Event)
    @GetMapping(value = "/flux",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        Flux<String> result = Flux
                .fromStream(IntStream.range(1,5).mapToObj(i->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException ignored){
                }
                    return "flux data--"+ i;
                }));
        return result;
    }


    // 阻塞5秒钟
    private String createStr() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello world";
    }
}

