package org.yqj.source.demo.basic.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/3/17
 * Email: yaoqijunmail@foxmail.com
 */
public class CompletableFutureTest {

    public static void main(String[] args){

//        futureSingle();

        // 1. CompletableFuture price set
//        completableFutureSet();

        // 2.calculateChain
//        calculateChain();

        try {
            testGetNow();
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
        System.out.println("finish");
    }

    public static void testGetNow() throws Exception{
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
            return 100;
        });
        future.join();
//        future.get();
    }

    public static void calculateChain() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        System.out.println("main start");
        CompletableFuture<Integer> sum = CompletableFuture.supplyAsync(CompletableFutureTest::calculateRandomValue, es)
                .thenApply(s->s + calculateRandomValue())
                .thenApply(s->s + calculateRandomValue());
//                .whenComplete((a, e)-> System.out.println(a));
        System.out.println(sum.join());
        System.out.println("main finish");
        es.shutdown();
    }

    private static int calculateRandomValue(){

        System.out.println("begin calculate value");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finish calculate value");

        return ThreadLocalRandom.current().nextInt(1000);
    }

    public static void completableFutureSet(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Thread processThread = new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("process current thread name " + Thread.currentThread().getName());
            completableFuture.complete("process finish");
        });
        processThread.setName("processThread");
        processThread.start();
        System.out.println("main start");
        completableFuture.whenComplete((a, s) -> {
            System.out.println("complete current thread " + Thread.currentThread().getName());
            System.out.println(a);
        });
        System.out.println("main finish");
    }

    public static void futureSingle() throws Exception{
        System.out.println("main start");
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> f = es.submit(() -> {
            Thread.sleep(2000);
            return 100;
        });
        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println("main finish");
        es.shutdown();
    }

}
