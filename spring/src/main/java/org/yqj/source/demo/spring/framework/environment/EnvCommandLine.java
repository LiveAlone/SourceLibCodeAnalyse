package org.yqj.source.demo.spring.framework.environment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/7
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class EnvCommandLine implements CommandLineRunner, EnvironmentAware {

    private Environment environment;

//    @Resource
//    private ComponentA componentA;
//
//    @Resource
//    private ComponentB componentB;

    @Override
    public void run(String... args) throws Exception {

//        if (environment instanceof AbstractEnvironment) {
//            // 不同环境配置
//            MutablePropertySources mutablePropertySources = ((AbstractEnvironment) environment).getPropertySources();
//            mutablePropertySources.forEach(propertySource -> {
//                log.info("********** source {}, -- {}", propertySource.getName(), propertySource);
//            });
//        }

//        log.info("gain value is :{}", environment.getProperty("server.port", Integer.class));

//        log.info("component a is :{}  component b is :{}", componentA.name(), componentB.name());
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
