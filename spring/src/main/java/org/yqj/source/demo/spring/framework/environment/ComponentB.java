package org.yqj.source.demo.spring.framework.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/10
 * Email: yaoqijunmail@foxmail.com
 */
//@Component
public class ComponentB {

    private final ComponentA componentA;

    public ComponentB(ComponentA componentA) {
        this.componentA = componentA;
    }

    public String name() {
        return "ComponentB";
    }

}
