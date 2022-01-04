package org.yqj.source.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yqj.source.demo.spring.cache.PersonService;
import org.yqj.source.demo.spring.core.event.FruitEventPublisherService;

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
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        log.info("starting command line {}", personService.gainCachePerson(123));
    }
}
