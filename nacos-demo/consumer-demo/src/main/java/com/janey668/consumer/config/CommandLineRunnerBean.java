package com.janey668.consumer.config;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerBean.class);

    @Override
    public void run(String... args) {
        // TODO 我们自己的业务逻辑
        String strArgs = Arrays.stream(args).collect(Collectors.joining("|"));
        logger.info("Application started with arguments:" + strArgs);
    }

}