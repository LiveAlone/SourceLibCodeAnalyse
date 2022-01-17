package org.yqj.source.demo.spring.framework.context;

import lombok.Data;
import lombok.Getter;
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
public class ComponentA {

    @Resource
    @Getter
    private ComponentB componentB;

//    private final ComponentB componentB;
//    public ComponentA(ComponentB componentB) {
//        this.componentB = componentB;
//    }

    public String name() {
        log.info("contain b name is :{}", componentB);
        return "ComponentA";
    }

}