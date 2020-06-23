package org.yqj.source.demo.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Ignore;
import org.junit.Test;
import reactor.core.publisher.Mono;

/**
 * Created by yaoqijun.
 * Date:2016-02-05
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class LettuceBasicTest {

    @Test
    @Ignore
    public void testGetRedisKey() throws Exception{
        RedisClient redisClient = RedisClient.create("redis://localhost/0");
        StatefulRedisConnection<String, String> stringStringStatefulRedisConnection = redisClient.connect();
        RedisCommands<String, String> redisCommands = stringStringStatefulRedisConnection.sync();
        String result = redisCommands.get("key");
        System.out.println(result);
        stringStringStatefulRedisConnection.close();
        redisClient.shutdown();
    }

    @Test
    @Ignore
    public void testGetKeyReactiveTask() throws Exception {
        RedisClient redisClient = RedisClient.create("redis://localhost/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        System.out.println("**** start");

//        connection.reactive().get("key").subscribe(s->{
//            System.out.println("****** get key value is " + s);
//            System.out.println("current thread is " + Thread.currentThread().getName());
//        });
//        Thread.sleep(2000);

//        connection.reactive().get("key").map(s -> {
//                    System.out.println(String.format("v1-%s-%s", s, Thread.currentThread().getName()));
//                    return s;
//                }).publishOn(Schedulers.parallel()).map(s -> {
//                    System.out.println(String.format("v2-%s-%s", s, Thread.currentThread().getName()));
//                    return s;
//                }).subscribe(System.out::println);
//        Thread.sleep(2000);

        connection.reactive().set("key2", "Hello world").block();
        Mono<String> mono = connection.reactive().get("key2");
        mono.subscribe(s->{
            System.out.println("****** get key value is " + s);
            System.out.println("current thread is " + Thread.currentThread().getName());
        });
        mono.block();

        System.out.println("**** all finish");
        connection.close();
        redisClient.shutdown();
    }

    @Test
    @Ignore
    public void testGetRunTask() throws Exception {
        RedisClient redisClient = RedisClient.create("redis://localhost/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        System.out.println("**** start");
        // event loop 线程名称
        RedisFuture redisFuture = connection.async().get("key");
        redisFuture.thenAccept(s -> {
            System.out.println("current thread is " + Thread.currentThread().getName());
            System.out.println("current s value is " + s);
        });
        redisFuture.get();
        System.out.println("**** all finish");
        connection.close();
        redisClient.shutdown();
    }

    @Test
    @Ignore
    public void testReadWriteExample() {
        RedisClient redisClient = RedisClient.create("redis://localhost/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        System.out.println("Connected to Redis");
        connection.sync().set("key", "Hello World");
        System.out.println(connection.sync().get("key"));
        connection.close();
        redisClient.shutdown();
    }

    @Test
    @Ignore
    public void testPingPongRedis() {
        RedisClient redisClient = RedisClient.create("redis://localhost/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        System.out.println(connection.sync().zrem("test_zset"));
        connection.close();
        redisClient.shutdown();
    }
}
