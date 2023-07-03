package com.java668.springboot3.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    public MyApplicationListener() {
        log.info("MyApplicationListener init");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("事件到达============== {}", event);
    }

}
