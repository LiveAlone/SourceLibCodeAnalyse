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

    @Resource
    private PersonService personService;

    @Resource
    private CacheManager cacheManager;

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 10; i++) {
            CachePerson cachePerson = personService.gainCachePerson(456);
            log.info("starting command line {}", cachePerson);
        }

        log.info("cache names is :{}", cacheManager.getCacheNames());

        for (String s : applicationContext.getBeanNamesForType(CacheManager.class)) {
            log.info("gain cache manage bean name is :{}", s);
        }

        Cache cache = cacheManager.getCache("itemCache");
        log.info("cache item is :{}", cache.get(Long.valueOf(123)));
    }
}
