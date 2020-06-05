package org.yqj.source.demo.webflux.reactor;

import java.time.Duration;
import java.util.Arrays;

/**
 * @author yaoqijun on 2017-11-05.
 */
public class BasicProjectReactorDemo {

    private static java.util.List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    public static void main(String[] args) {

        testFirstEmit();

//        testWait();

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        testZipWith();

//        httpServerTest();
    }

    private static void testFirstEmit(){
        reactor.core.publisher.Mono<String> a = reactor.core.publisher.Mono.just("oops I'm late").delayElement(Duration.ofSeconds(3));
        reactor.core.publisher.Flux<String> b = reactor.core.publisher.Flux.just("let's get", "the party", "started").delayElements(Duration.ofSeconds(4));

        reactor.core.publisher.Flux.first(a, b)
                .toIterable()
                .forEach(System.out::println);
    }

    public static void testWait() {
        reactor.core.publisher.Mono.just("hello")
                .concatWith(reactor.core.publisher.Mono.just(" world"))
                .delaySubscription(Duration.ofSeconds(5))
                .subscribe(System.out::println);
    }


    public static void testZipWith(){
        reactor.core.publisher.Mono<String> missing = reactor.core.publisher.Mono.just("s");
        reactor.core.publisher.Flux.fromIterable(words)
                .flatMap(word -> reactor.core.publisher.Flux.fromArray(word.split("")))
                .concatWith(missing)
                .distinct()
                .sort()
                .zipWith(reactor.core.publisher.Flux.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string))
                .subscribe(System.out::println);
    }

    public static void testHttpServer(){
//        HttpServer.create().newHandler((httpServerRequest, httpServerResponse) ->
//                httpServerResponse.sendWebsocket((websocketInbound, websocketOutbound) ->
//                        websocketOutbound.options(sendOptions ->
//                                sendOptions.flushOnEach())
//                                .sendString(Flux.just("test").delayElements(Duration.ofSeconds(100)).repeat())))
//                .block();
    }

    public static void FluxTest(){
        java.util.List<java.util.List<Integer>> lists = reactor.core.publisher.Flux.range(1,100)
                .map(integer -> integer * 100)
                .filter(integer -> integer > 6300)
                .buffer(10).collectList().block();

        for (java.util.List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
