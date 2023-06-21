package com.java668.webflux.test;

import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/21 11:10
 **/
public class MonoTest {

    public static void main(String[] args) {
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.empty()).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);


    }

}