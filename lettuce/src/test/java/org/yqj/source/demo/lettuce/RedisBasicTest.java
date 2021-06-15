package org.yqj.source.demo.lettuce;

import io.lettuce.core.KeyScanCursor;
import io.lettuce.core.RedisClient;
import io.lettuce.core.ScanArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/2/22
 * Email: yaoqijunmail@foxmail.com
 */
@Ignore
public class RedisBasicTest {

    @Test
    @Ignore
    public void testGetRedisKey() throws Exception{
        RedisClient redisClient = RedisClient.create("redis://localhost/0");
        StatefulRedisConnection<String, String> stringStringStatefulRedisConnection = redisClient.connect();
        RedisCommands<String, String> redisCommands = stringStringStatefulRedisConnection.sync();
        ScanArgs scanArgs = new ScanArgs().match("day*").limit(1);
        KeyScanCursor<String> cursor = redisCommands.scan(scanArgs);
        System.out.println(cursor.getKeys());
        System.out.println(cursor.getCursor());

        cursor = redisCommands.scan(cursor, scanArgs);
        System.out.println(cursor.getKeys());
        System.out.println(cursor.getCursor());

        stringStringStatefulRedisConnection.close();
        redisClient.shutdown();
    }
}
