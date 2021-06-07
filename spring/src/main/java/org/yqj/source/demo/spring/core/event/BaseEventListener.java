package org.yqj.source.demo.spring.core.event;

import com.sun.tools.corba.se.idl.constExpr.Or;
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
    public void fruitListener(FruitEvent fruitEvent) {
        log.info("fruit event listener {} get event {}", Thread.currentThread().getName(), fruitEvent);
    }

    @EventListener
    public void appleListener(AppleEvent appleEvent) {
        log.info("apple event listener {} get event {}", Thread.currentThread().getName(), appleEvent);
    }

    @EventListener
    public void orangeListener(OrangeEvent orangeEvent) {
        log.info("orange event listener {} get event {}", Thread.currentThread().getName(), orangeEvent);
    }

    @EventListener
    public void northAppleListener(NorthAppleEvent northAppleEvent) {
        log.info("north apple event listener {} get event {}", Thread.currentThread().getName(), northAppleEvent);
    }
}
