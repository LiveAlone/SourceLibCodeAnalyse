package org.yqj.source.demo.webflux.reactor;

import reactor.core.scheduler.Schedulers;

public class DocDemo {
    public static void main(String[] args) {

//        errorHandle();

        testSchedulersHandlerConfig();
    }

    public static void testSchedulersHandlerConfig(){
        reactor.core.scheduler.Scheduler scheduler = Schedulers.newParallel("parallel-scheduler", 2);

        reactor.core.publisher.Flux<String> flux = reactor.core.publisher.Flux.just(1)
                .map(i -> {
                    System.out.println("Map1 thread name is " + Thread.currentThread().getName());
                    return  i + 10;
                })
//                .publishOn(scheduler)
                .subscribeOn(scheduler)
                .map(i -> {
                    System.out.println("Map2 thread name is " + Thread.currentThread().getName());
                    return String.format("values - %s", 2);
                });

        for (int i = 0; i < 6; i++){
            new Thread(()->{
//                System.out.println("current new start consumer, name is " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flux.subscribe(s->{
                    System.out.println("current thread is " + Thread.currentThread().getName()+ " with value is " + s);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
//                System.out.println("current new start consumer, name is " + Thread.currentThread().getName() + "has finish all content");
            }).start();
        }
    }

    public static void errorHandle(){

//        Flux.range(1, 10)
//                .map(integer -> {
//                    if(integer > 6){
//                        throw new IllegalStateException("error integer " + integer);
//                    }
//                    return String.valueOf(integer);
//                })
//                .onErrorReturn("error integer")
//                .subscribe(System.out::println);


//        Flux<String> flux =
//                Flux.interval(Duration.ofMillis(250))
//                        .map(input -> {
//                            if (input < 3) return "tick " + input;
//                            throw new RuntimeException("boom");
//                        })
//                        .onErrorReturn("Uh oh");
//
//        flux.subscribe(System.out::println);

//        Flux.interval(Duration.ofMillis(250))
//                .map(input -> {
//                    if (input < 3) return "tick " + input;
//                    throw new RuntimeException("boom");
//                })
//                .elapsed()
//                .retry(1)
//                .subscribe(System.out::println,
//                        System.err::println);

//        Flux<String> flux =
//                Flux.<String>error(new IllegalArgumentException())
//                        .doOnError(System.out::println)
//                        .retryWhen(companion -> companion.take(3));

//        Flux.<String>error(new IllegalArgumentException())
//                .retryWhen(companion -> companion
//                                .zipWith(Flux.range(1, 4),
//                                        (error, index) -> {
//                                            if (index < 4) return index;
//                                            else throw Exceptions.propagate(error);
//                                        }))
//                .subscribe(System.out::println);

        try {
            Thread.sleep(2100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
