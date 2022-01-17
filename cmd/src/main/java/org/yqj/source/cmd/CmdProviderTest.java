package org.yqj.source.cmd;

import javax.cache.event.EventType;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/17
 * Email: yaoqijunmail@foxmail.com
 */
public class CmdProviderTest {

    public String providerString() {
        return new String("hello world");
    }

    public EventType gainCacheEntity() {
        return EventType.CREATED;
    }
}
