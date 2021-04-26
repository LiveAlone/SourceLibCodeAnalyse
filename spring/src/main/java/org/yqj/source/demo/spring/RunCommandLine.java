package org.yqj.source.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.yqj.source.demo.spring.core.event.BaseEvent;
import org.yqj.source.demo.spring.core.event.BaseEventChild;
import org.yqj.source.demo.spring.core.event.BaseEventSubChild;

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
public class RunCommandLine implements CommandLineRunner{

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void run(String... args) throws Exception {
        log.info("starting command line ...");
        log.info("*************** begin");
        applicationEventPublisher.publishEvent(new BaseEventChild(123, "yaoqijun"));
        log.info("*************** end");
    }
}
