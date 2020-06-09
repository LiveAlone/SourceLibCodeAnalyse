package org.yqj.source.demo.webflux.reactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/6/7
 * Email: yaoqijunmail@foxmail.com
 */
public class DocDemoMain {

    public static void main(String[] args) {

//        subscribeMethodVoid();

//        baseSubscribeOutput();

//        fluxGenerateFunc();

//        fluxCreateConfig();

//        fluxPushConfig();

//        fluxHandleConfig();

//        publishOnTest();

        subscribeOnTest();

//        errorHandlerCondition();

//        retryHandler();
    }

    public static void retryHandler() {
        Flux.interval(Duration.ofMillis(250))
                .map(s -> {
                    if (s < 3) {
                        return "tick " + s;
                    }
                    throw new RuntimeException("boom");
                })
                .retry(2)
                .elapsed()
                .subscribe(System.out::println, System.out::println);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void errorHandlerCondition() {
//        Flux.just(1, 2, 3, 4, 5, 0, 6, 7, 9)
//                .map(i -> i * 2)
//                .map(i -> 100 / i)
//                .subscribe(System.out::println, Throwable::printStackTrace);

        // 异常返回固定值
//        Flux.just(1, 2, 3, 4, 5, 0, 6, 7, 9)
//                .map(i -> i * 2)
//                .map(i -> 100 / i)
//                .onErrorReturn(6666)
//                .subscribe(System.out::println);

//        Flux.just(1, 2, 3, 4, 5, 0, 6, 7, 9)
//                .map(i -> i * 2)
//                .map(i -> 100 / i)
//                .onErrorResume(error -> {
//                    System.out.println("getting error " + error.getMessage());
//                    return Flux.just(666);
//                }).subscribe(System.out::println, Throwable::printStackTrace);

//        Flux.just(1, 2, 3, 4, 5, 0, 6, 7, 9)
//                .map(i -> i * 2)
//                .map(i -> 100 / i)
//                .onErrorResume(error -> {
//                    System.out.println("getting error " + error.getMessage());
//                    return Flux.error(new RuntimeException("zero error"));
//                }).subscribe(System.out::println);

        Flux.just(1, 2, 3, 4, 5, 0, 6, 7, 9)
                .map(i -> i * 2)
                .map(i -> 100 / i)
                .doFinally(signalType -> {
                    System.out.println(signalType);
                })
                .subscribe(System.out::println);
    }

    public static void subscribeOnTest() {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        final Flux<String> flux = Flux
                .range(1, 1000)
                .map(i -> {
                    System.out.println("map1 current thread is " + Thread.currentThread().getName());
                    return i + 10;
                })
                .subscribeOn(s)
                .map(i -> {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("map2 current thread is " + Thread.currentThread().getName());
                    return "value is " + i;
                });

        for (int i=0; i<4; i++){
            flux.subscribe(System.out::println);
        }
    }

    public static void publishOnTest() {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        final Flux<String> flux = Flux
                .range(1, 1000)
                .map(i -> {
                    int value = i * 10;
                    System.out.println("map1 current thread is " + Thread.currentThread().getName() + " value is " + value);
                    return value;
                })
                .publishOn(s)
                .map(i -> {
                    System.out.println("map2 current thread is " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "value " + i;
                });

//        for (int i = 0; i < 4; i++) {
//            new Thread(() -> flux.subscribe(System.out::println), String.format("single_test_push_on_thread" + i)).start();
//        }

        new Thread(() -> flux.subscribe(System.out::println), String.format("single_test_push_on_thread")).start();
    }

    public static void fluxHandleConfig() {
        Flux.just(1, 2, 3, 4).handle((value, sink) -> {
            if (value < 3) {
                sink.next(value);
            }
        }).subscribe(System.out::println);
    }

    public static void fluxPushConfig() {
        Flux.push(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        }).subscribe(System.out::println);
    }

    public static void fluxCreateConfig() {
        Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        }, FluxSink.OverflowStrategy.DROP).subscribe(System.out::println);
    }

    public static void fluxGenerateFunc() {
        Flux.generate(() -> 1, (state, sink) -> {
            sink.next(state * 3);
            if (state >= 10) {
                sink.complete();
            }
            return state + 1;
        }, s -> System.out.println("state consumer is " + s)).subscribe(System.out::println);
    }

    public static void baseSubscribeOutput() {
        Flux.range(1, 100).subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                System.out.println("hookOnSubscribe");
                request(1);
            }

            @Override
            protected void hookOnNext(Integer value) {
                System.out.println("current test all value is " + value);
                request(1);
            }
        });
    }

    public static void subscribeMethodVoid() {
        Flux.range(100, 1).subscribe(System.out::println);

        Flux.range(1, 10)
                .map(Integer::doubleValue)
                .filter(s -> s > 3)
                .map(String::valueOf)
                .subscribe(System.out::println, System.out::println);

        Mono.just(100).subscribe(System.out::println);
    }
}
