package com.janey668.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/03/08 16:41
 **/
@Slf4j
@Component
public class CustomApplicationListener implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        log.info("===========================================");
//        int i = 1/0;
    }

}