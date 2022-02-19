package org.yqj.source.tool.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.yqj.source.tool.basic.base.concurrent.Concurrent;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/2/18
 * Email: yaoqijunmail@foxmail.com
 */
@Slf4j
public class NoneTest {

    @Test
    public void testConcurrent() {
        Concurrent concurrent = new Concurrent();
        concurrent.atomicAdder();
    }
}
