package org.yqj.net.transport;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by yaoqijun.
 * Date:2016-02-05
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Ignore
@Slf4j
public class TestContent {

    @Test
    public void testLogLevel() {
        log.trace("this is trace info");
        log.debug("this is debug info");
        log.info("this is main empty content");
        log.warn("this is warn info");
        log.error("this is error info");
    }

}
