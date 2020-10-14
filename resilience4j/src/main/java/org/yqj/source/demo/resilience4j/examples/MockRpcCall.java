package org.yqj.source.demo.resilience4j.examples;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/10/14
 * Email: yaoqijunmail@foxmail.com
 */
@Data
public class MockRpcCall implements Supplier<String> {

    private int failRate = 50;

    private long baseDelay = 200;

    private long delayRandom = 200;


    @Override
    public String get() {
        if (ThreadLocalRandom.current().nextInt(100) < failRate){
            throw new RuntimeException("rpcCallError");
        }
        try {
            Thread.sleep(baseDelay + ThreadLocalRandom.current().nextLong(delayRandom));
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        return "SUCCESS";
    }
}
