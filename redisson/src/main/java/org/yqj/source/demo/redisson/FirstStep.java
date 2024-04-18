package org.yqj.source.demo.redisson;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2024/4/18
 * Email: yaoqijunmail@foxmail.com
 */
public class FirstStep {
    public static void main(String[] args) {
        // 1. Create config object
        Config config = new Config();
//        config.useClusterServers().addNodeAddress("redis://127.0.0.1:7181");
//        config = Config.fromYAML(new File("config-file.yaml"));
        config.useSingleServer().setAddress("redis://localhost:6379");
        config.setCodec(new StringCodec());

        // 2. Create Redisson instance
        RedissonClient redisson = Redisson.create(config);

        // 3. map
        RMap<String, String> map = redisson.getMap("myMap");
        map.put("key1", "value1");
        map.put("key2", "value2");

        redisson.shutdown();
    }
}
