package org.yqj.source.demo.spring;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yqj.source.demo.spring.framework.aop.m2.Person;


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
    private Person person;

    @Override
    public void run(String... args) throws Exception {
        person.run("yaoqijun");
    }
}
