package org.yqj.source.demo.webflux.reactor;

/**
 * @author yaoqijun on 2017-11-07.
 */
public class SourceCodeDemo {
    public static void main(String[] args) {
//        fluxJustTest();
//        monoJustTest();
    }

    private static void fluxJustTest(){
        /**
         * flux 通过修饰器模式
         * subscribe 生成 Subscriber 修饰， 通过request
         */
        reactor.core.publisher.Flux.just(1,2,3,4)
                .filter(in -> in > 2)
                .map(integer -> "test condition " + integer)
                .subscribe(System.out::println);
    }

    private static void monoJustTest(){
        reactor.core.publisher.Mono.just(1)
                .filter(integer -> integer > 0)
                .map(integer -> "current value is " + integer)
                .subscribe(System.out::println);
    }
}
