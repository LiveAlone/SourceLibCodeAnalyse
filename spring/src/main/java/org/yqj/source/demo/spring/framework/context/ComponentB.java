package org.yqj.source.demo.spring.framework.context;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
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
@Component
@Slf4j
public class ComponentB {

//    @Resource
//    private ComponentA componentA;

    private final ComponentA componentA;
    public ComponentB(ComponentA componentA) {
        this.componentA = componentA;
    }

    public String name() {
        log.info("container a info is :{}", componentA);
        return "ComponentB";
    }

}
