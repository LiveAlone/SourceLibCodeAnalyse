package org.yqj.source.demo.spring.core.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/4/26
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class BaseEventListener {

    @EventListener
    public void listenerBase(BaseEvent baseEvent) {
        log.info("base event listener gain base event :{}", baseEvent);
    }

    @EventListener
    public void listChildBase(BaseEventChild baseEventChild) {
        log.info("base event child listener base event :{}", baseEventChild);
    }

    @EventListener
    public void listSubChildBase(BaseEventSubChild baseEventSubChild) {
        log.info("base event child listener base event :{}", baseEventSubChild);
    }
}
