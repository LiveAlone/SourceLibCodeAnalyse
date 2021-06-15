package org.yqj.source.demo.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/2/1
 * Email: yaoqijunmail@foxmail.com
 */
@Ignore
public class PfCountTest {

    @Test
    public void testPfCountRate(){
        RedisClient redisClient = RedisClient.create("redis://localhost/0");
        StatefulRedisConnection<String, String> stringStringStatefulRedisConnection = redisClient.connect();
        RedisCommands<String, String> redisCommands = stringStringStatefulRedisConnection.sync();

        ThreadLocalRandom random = ThreadLocalRandom.current();
        String pfKey = "pfTestKey1";
        int diff = 0;
        for (int i = 0; i < 10000; i++) {
            long change = redisCommands.pfadd(pfKey, String.format("%d_%d", random.nextInt(10000000), i));
            diff += change;
            System.out.println("current pos " + i + "  diff is " + diff);
        }
        long totalCount = redisCommands.pfcount(pfKey);
        System.out.println("total count 10000, diff count " + diff + " query count : " + totalCount);
    }

}
