package org.yqj.source.demo.lettuce;

import com.google.common.io.ByteStreams;
import com.google.common.primitives.Bytes;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import redis.clients.jedis.BitPosParams;
import redis.clients.jedis.Jedis;

import java.util.List;

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
    public void bitBasicTest() {
        String key = "bitNameKey";
        Jedis jedis = new Jedis("localhost", 6379);
//        System.out.println(jedis.setbit(key, 0, true));
//        for (byte aByte : jedis.get(key).getBytes()) {
//            System.out.println(aByte);
//        }
//        System.out.println(jedis.getbit(key, 2));
//        System.out.println(jedis.bitpos(key, true));
//        System.out.println(jedis.bitcount(key));

//        byte first = jedis.get(key.getBytes())[0];
//        byte pos1 = (byte) 0x80;
//        byte pos3 = (byte) 0x20;
//        System.out.println(pos1);
//        System.out.println(pos3);
//        System.out.println(pos1 & first);
//        System.out.println(pos3 & first);
        System.out.println(ByteUtil.listPost(jedis.get(key.getBytes())));
    }

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

    public List<Integer> convertPostActive(byte[] basic) {
        return null;
    }
}
