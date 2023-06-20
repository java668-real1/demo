package com.java668.webflux.test;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class FluxTest {

    public static void main(String[] args) throws InterruptedException {


        // just()：可以指定序列中包含的全部元素。创建出来的 Flux 序列在发布这些元素之后会自动结束。
        Flux.just("Hello", "World").subscribe(System.out::println);

        // fromArray()，fromIterable()和 fromStream()：可以从一个数组、Iterable 对象或 Stream 对象中创建 Flux 对象。
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);

        // empty()：创建一个不包含任何元素，只发布结束消息的序列。
        Flux.empty().subscribe(System.out::println);

        // range(int start, int count)：创建包含从 start 起始的 count 个数量的 Integer 对象的序列。
//        Flux.range(1, 10).subscribe(System.out::println);

        // error(Throwable error)：创建一个只包含错误消息的序列。
//        Flux.error(() -> new Exception("Flux.error")).subscribe(System.out::println);

        // never()：创建一个不包含任何消息通知的序列。二者区别在于：empty里面至少还有一个结束消息，而never则是真的啥都没有。FluxTest
//        Flux.never().subscribe(System.out::println);

        // interval(Duration period)和 interval(Duration delay, Duration period)：创建一个包含了从 0 开始递增的 Long 对象的序列。其中包含的元素按照指定的间隔来发布。除了间隔时间之外，还可以指定起始元素发布之前的延迟时间。
        Flux.interval(Duration.of(1, ChronoUnit.SECONDS)).subscribe(System.out::println);
        Thread.sleep(5000);
    }
}
