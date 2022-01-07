package org.yqj.source.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.yqj.source.demo.spring.cache.CachePerson;
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
    @Override
    public void run(String... args) throws Exception {
    }
}
