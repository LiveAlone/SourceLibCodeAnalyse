package org.yqj.source.demo.webflux.reactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.UnicastProcessor;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yaoqijun on 2018-04-19.
 */
public class DocDemo2 {

    private static int no = 1;

    public static void main(String[] args) {

//        doPut("www.example.com", Mono.just("Walter"))
//                .subscriberContext(Context.of(HTTP_CORRELATION_ID, "2-j3r9afaf92j-afkaf")).subscribe(System.out::println);

//        contextTestCondition();

//        parallelCondition();

//        bufferCondition();

//        windowCondition();

//        groupMapping();

//        connectableFluxTest();

//        hotAndColdContext();

        schedulerTest();

//        handleTest();

//        fluxCreate();

//        fluxGenerateState();

//        baseSubscriberTest();
    }

    static final String HTTP_CORRELATION_ID = "reactive.http.library.correlationId";

    private static reactor.core.publisher.Mono<Tuple2<Integer, String>> doPut(String url, reactor.core.publisher.Mono<String> data) {
        reactor.core.publisher.Mono<Tuple2<String, Optional<Object>>> dataAndContext =
                data.zipWith(reactor.core.publisher.Mono.subscriberContext()
                        .map(c -> c.getOrEmpty(HTTP_CORRELATION_ID)));

        return dataAndContext.<String>handle((dac, sink) -> {
                    if (dac.getT2().isPresent()) {
                        sink.next("PUT <" + dac.getT1() + "> sent to " + url + " with header X-Correlation-ID = " + dac.getT2().get());
                    } else {
                        sink.next("PUT <" + dac.getT1() + "> sent to " + url);
                    }
                    sink.complete();
                }).map(msg -> Tuples.of(200, msg));
    }

    private static void contextTestCondition(){
        String key = "message";
//        Flux.just("Hello", "YAO", "QI", "jun")
//                .flatMap( s -> Mono.subscriberContext()
//                        .map( ctx -> s + " " + ctx.get(key)))
//                .subscriberContext(ctx -> ctx.put(key, "World"))
//                .subscribe(System.out::println);

//        Flux.just("Hello", "YAO", "QI", "jun")
//                .subscriberContext(ctx -> ctx.put(key, "World"))
//                .flatMap( s -> Mono.subscriberContext()
//                        .map( ctx -> s + " " + ctx.getOrDefault(key, "NONE")))
//                .subscribe(System.out::println);

//        Flux.just("Hello", "YAO", "QI", "jun")
//                .flatMap( s -> Mono.subscriberContext()
//                        .map( ctx -> s + " " + ctx.get(key)))
//                .subscriberContext(ctx -> ctx.put(key, "Reactor"))
//                .subscriberContext(ctx -> ctx.put(key, "World"))
//                .subscribe(System.out::println);

//        Flux.just("Hello", "YAO", "QI", "jun")
//                .flatMap( s -> Mono.subscriberContext()
//                        .map( ctx -> s + " " + ctx.get(key)))
//                .subscriberContext(ctx -> ctx.put(key, "Reactor"))
//                .flatMap( s -> Mono.subscriberContext()
//                        .map( ctx -> s + " " + ctx.get(key)))
//                .subscriberContext(ctx -> ctx.put(key, "World"))
//                .subscribe(System.out::println);

        reactor.core.publisher.Flux.just("Hello", "YAO", "QI", "jun")
                .flatMap( s -> reactor.core.publisher.Mono.subscriberContext()
                        .map( ctx -> s + " " + ctx.get(key)))
                .flatMap( s -> reactor.core.publisher.Mono.subscriberContext()
                        .map( ctx -> s + " " + ctx.get(key)))
                .subscriberContext(ctx -> ctx.put(key, "World"))
                .subscribe(System.out::println);
    }

    private static void parallelCondition(){
//        Flux.range(1, 10)
//                .parallel(2)
//                .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));

        reactor.core.publisher.Flux.range(1, 100)
                .parallel(3)
                .runOn(Schedulers.newParallel("yqj", 3))
                .subscribe(i -> {
                    System.out.println(Thread.currentThread().getName() + " -> " + i);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    private static void bufferCondition(){
        reactor.core.publisher.Flux.range(1, 10).buffer(5,3).subscribe(System.out::println);

//        Flux.just(1, 3, 5, 2, 4, 6, 11, 12, 13)
//                .bufferWhile(i -> i % 2 == 0)
//                .subscribe(System.out::println);
    }

    private static void windowCondition(){
//        Flux.range(1, 10)
//                .window(5, 3)
//                .concatMap(g -> g.defaultIfEmpty(-1))
//                .subscribe(System.out::println);
        reactor.core.publisher.Flux.just(1, 3, 5, 2, 4, 6, 11, 12, 13)
                .windowWhile(i -> i % 2 == 0)
                .concatMap(g -> g.defaultIfEmpty(-1))
                .subscribe(System.out::println);
    }

    private static void groupMapping(){
        reactor.core.publisher.Flux.just(1, 3, 5, 2, 4, 6, 11, 12, 13)
                .groupBy(i -> i % 2 == 0 ? "even" : "odd")
                .concatMap(g -> g.defaultIfEmpty(-1) //if empty groups, show them
                        .map(String::valueOf) //map to string
                        .startWith(g.key())).subscribe(System.out::println); //start with the group's key
    }

    private static void connectableFluxTest(){
//        Flux<Integer> source = Flux.range(1, 3)
//                .doOnSubscribe(s -> System.out.println("subscribed to source"));
//
//        ConnectableFlux<Integer> co = source.publish();
//
//        co.subscribe(System.out::println, e -> {}, () -> {});
//        co.subscribe(System.out::println, e -> {}, () -> {});
//
//        System.out.println("done subscribing");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("will now connect");
//
//        co.connect();


//        Flux<Integer> source = Flux.range(1, 3)
//                .doOnSubscribe(s -> System.out.println("subscribed to source"));
//
//        Flux<Integer> autoCo = source.publish().autoConnect(2);
//
//        autoCo.subscribe(System.out::println, e -> {}, () -> {});
//        System.out.println("subscribed first");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("subscribing second");
//        autoCo.subscribe(System.out::println, e -> {}, () -> {});
    }

    public static void hotAndColdContext(){
//        Flux<String> source = Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
////                .doOnNext(System.out::println)
//                .filter(s -> s.startsWith("o"))
//                .map(String::toUpperCase);
//
//        source.subscribe(d -> System.out.println("Subscriber 1: "+d));
//        source.subscribe(d -> System.out.println("Subscriber 2: "+d));

        // hot condition
        UnicastProcessor<String> hotSource = UnicastProcessor.create();

        reactor.core.publisher.Flux<String> hotFlux = hotSource.publish()
                .autoConnect()
                .map(String::toUpperCase);

        hotFlux.subscribe(d -> System.out.println("Subscriber 1 to Hot Source: "+d));

        hotSource.onNext("blue");
        hotSource.onNext("green");

        hotFlux.subscribe(d -> System.out.println("Subscriber 2 to Hot Source: "+d));

        hotSource.onNext("orange");
        hotSource.onNext("purple");
        hotSource.onComplete();
    }

    private static void schedulerTest(){
        reactor.core.publisher.Flux.range(1, 1000)
                .publishOn(Schedulers.newParallel("haha"))
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        subscription.request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        System.out.println(Thread.currentThread().getName() + " " + value);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        request(5);
                    }
                });
    }

    private static void handleTest(){
        reactor.core.publisher.Flux.range(1, 10)
                .handle((integer, synchronousSink) -> {
                   if (integer % 2 ==0){
                       synchronousSink.next(integer);
                   }else {
                       System.out.println("context ignore value is " + integer);
                   }
                }).subscribe(System.out::println);
    }

    private static void fluxCreate(){
        reactor.core.publisher.Flux.create(fluxSink -> fluxSink.next("yaoqijun")).subscribe(System.out::println);
    }

    private static void fluxGenerateState(){
        reactor.core.publisher.Flux.generate(AtomicInteger::new, (atomicInteger, synchronousSink) -> {
            long i = atomicInteger.getAndIncrement();
            synchronousSink.next("3 x " + i + " = " + 3*i);
            if (i == 10){
                synchronousSink.complete();
            }
            return atomicInteger;
        }).subscribe(System.out::println);
    }

    private static void baseSubscriberTest(){
        reactor.core.publisher.Flux.range(1, 10).subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                subscription.request(1);
            }

            @Override
            protected void hookOnNext(Integer value) {
                System.out.println(value);
                request(1);
            }
        });
    }
}
