package org.yqj.source.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yaoqijun.
 * Date:2016-02-05
 * Email:yaoqj@terminus.io
 * Descirbe:
 */

@Slf4j
public class TestInit {
    @Test
    public void testNone() {
        log.info("task none condition");
        Assert.assertEquals(1L, 1L);
    }
}
