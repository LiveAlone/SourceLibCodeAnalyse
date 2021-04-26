package org.yqj.source.demo.spring.core.event;

import org.springframework.context.ApplicationEvent;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/4/26
 * Email: yaoqijunmail@foxmail.com
 */
public class BaseEvent extends ApplicationEvent {

    private String name;

    public BaseEvent(Object source, String name) {
        super(source);
        this.name = name;
    }
}
