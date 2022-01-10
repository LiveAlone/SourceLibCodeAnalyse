package org.yqj.source.demo.spring.event;

import lombok.ToString;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/6/7
 * Email: yaoqijunmail@foxmail.com
 */
@ToString(callSuper = true)
public class NorthAppleEvent extends AppleEvent {

    public NorthAppleEvent(Object source, String color) {
        super(source, color, "north");
    }
}
