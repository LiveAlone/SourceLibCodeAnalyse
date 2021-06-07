package org.yqj.source.demo.spring.core.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/6/7
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class FruitBasicEventListener implements ApplicationListener<FruitEvent> {

    @Override
    public void onApplicationEvent(FruitEvent event) {
        log.info("interface fruit basic event listener gain event :{}", event);
    }
}
