package org.yqj.source.demo.spring.framework.aop.m2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/29
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class Person implements Runner, Coder, Worker {


    @Override
    public void code(String name) {
        log.info("person :{} is coding", name);
    }

    @Override
    public void run(String name) {
        log.info("person :{} is running", name);
    }

    @Override
    public void work(String name) {
        log.info("person :{} is working", name);
    }
}
