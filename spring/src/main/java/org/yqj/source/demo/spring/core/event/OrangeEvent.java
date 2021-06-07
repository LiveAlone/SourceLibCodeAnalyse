package org.yqj.source.demo.spring.core.event;

import lombok.Getter;
import lombok.ToString;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/6/7
 * Email: yaoqijunmail@foxmail.com
 */
@ToString(callSuper = true)
public class OrangeEvent extends FruitEvent {

    @Getter
    private boolean sweet;

    public OrangeEvent(Object source, String color, boolean sweet) {
        super(source, color);
        this.sweet = sweet;
    }
}
