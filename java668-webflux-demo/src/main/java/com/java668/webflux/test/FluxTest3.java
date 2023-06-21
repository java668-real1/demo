package com.java668.webflux.test;

import reactor.core.publisher.Flux;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/21 11:30
 **/
public class FluxTest3 {

    public static void main(String[] args) {
//        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
        System.out.println("=======");
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);
        System.out.println("=======");
        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);

        Flux.range(1, 100).window(20).subscribe(System.out::println);

    }
}