package org.yqj.source.demo.lettuce;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/7/5
 * Email: yaoqijunmail@foxmail.com
 */
@Slf4j
//@Ignore
public class JedisBasicTest {

    @Test
    public void basicTest() {
        Jedis jedis = new Jedis("localhost", 6379);
        for (int i = 0; i < 100; i++) {
            jedis.zadd("testSet", i, String.valueOf(i));
        }
        System.out.println(jedis.zrank("testSet", "1024"));
        System.out.println(jedis.zrank("testSet", "66"));
        System.out.println(jedis.zrank("testSet", "100"));
        System.out.println(jedis.zrank("testSet", "0"));
    }

    @Test
    public void incDescTest() {
        String counterKey = "counterKey";
        Jedis jedis = new Jedis("192.168.148.205", 12345);
        System.out.println(jedis.get(counterKey));
    }
}
