package org.yqj.source.demo.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import org.junit.Test;

/**
 * Created by yaoqijun.
 * Date:2016-02-05
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class LettuceBasicTest {

    @Test
    public void testGetValue(){
        RedisClient redisClient = RedisClient.create("redis://localhost/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        String value = connection.sync().get("key");
        System.out.println(value);
        connection.close();
        redisClient.shutdown();
    }

    @Test
    public void testGetContent(){
        RedisClient redisClient = RedisClient.create("redis://localhost/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        System.out.println("Connected to Redis");
        connection.sync().set("key", "Hello World");

        connection.close();
        redisClient.shutdown();
    }

}
