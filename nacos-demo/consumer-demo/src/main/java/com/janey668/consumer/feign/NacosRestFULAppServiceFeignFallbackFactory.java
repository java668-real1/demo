package com.janey668.consumer.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * https://www.cnblogs.com/studyjobs/p/16656430.html
 */
@Slf4j
@Component
public class NacosRestFULAppServiceFeignFallbackFactory implements FallbackFactory<NacosRestFULAppServiceFeign> {
    @Override
    public NacosRestFULAppServiceFeign create(Throwable throwable) {
        return new NacosRestFULAppServiceFeign() {

            @Override
            public String sayHello(String name) {
                return null;
            }

            @Override
            public String test(String name) {
                String message = throwable.getMessage();
                return "ccccccccccccccccccc";
            }
        };
    }
}
