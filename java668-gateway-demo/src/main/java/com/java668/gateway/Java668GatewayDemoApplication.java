package com.java668.gateway;

import com.java668.gateway.dto.UserRespDTO;
import com.java668.gateway.filter.RequestTimeFilter;
import com.java668.gateway.filter.RequestTimeGatewayFilterFactory;
import com.java668.gateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class Java668GatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java668GatewayDemoApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> {
                            return f.addRequestHeader("Hello", "World")
                                    .addResponseHeader("test", "test");
                        })
                        .uri("http://httpbin.org:80"))
                .build();
    }

    @RequestMapping("/fallback")
    public Flux<UserRespDTO> fallback() {
        UserRespDTO test1 = UserRespDTO.builder().id(1L).name("test1").build();
        UserRespDTO test2 = UserRespDTO.builder().id(2L).name("test2").build();
        return Flux.just(test1, test2);
    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/customer/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
        // @formatter:on
    }


    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

}
