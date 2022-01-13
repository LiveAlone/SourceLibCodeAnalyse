package org.yqj.source.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yqj.source.demo.spring.framework.context.ComponentA;
import org.yqj.source.demo.spring.framework.context.ComponentB;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/8/15
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class RunCommandLine implements CommandLineRunner {

    @Resource
    private ComponentA componentA;

    @Resource
    private ComponentB componentB;

    @Override
    public void run(String... args) throws Exception {
        log.info("component a is :{}  component b is :{}", componentA.name(), componentB.name());
    }
}
