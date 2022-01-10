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
public class ComponentA {

    private final ComponentB componentB;

    public ComponentA(ComponentB componentB) {
        this.componentB = componentB;
    }

    public String name() {
        return "ComponentA";
    }

}
