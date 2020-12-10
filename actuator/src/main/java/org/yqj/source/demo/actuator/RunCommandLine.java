package org.yqj.source.demo.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.yqj.source.demo.actuator.health.LocalReporter;

import javax.annotation.Resource;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/8/15
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class RunCommandLine implements CommandLineRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Resource
    private LocalReporter localReporter;

    @Override
    public void run(String... args) throws Exception {
        log.info("starting command line ...");
        new Thread(() -> {
            while (true){
                localReporter.report(ThreadLocalRandom.current().nextDouble(100D));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
