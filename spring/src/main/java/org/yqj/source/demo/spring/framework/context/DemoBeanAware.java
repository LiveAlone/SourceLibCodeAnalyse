package org.yqj.source.demo.spring.framework.context;

import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/18
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class DemoBeanAware implements BeanNameAware, ApplicationContextAware {

    @Resource
    private ComponentA componentA;

    @Autowired
    private ComponentB componentB;

    private String name;

    private ApplicationContext applicationContext;

    static {
        log.info("demo bean aware class is loading ...");
    }

    @PostConstruct
    public void init() {
        log.info("************ post construct method");
    }

    public String name() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
