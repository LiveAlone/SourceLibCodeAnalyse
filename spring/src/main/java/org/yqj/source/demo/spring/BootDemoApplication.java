package org.yqj.source.demo.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/8/15
 * Email: yaoqijunmail@foxmail.com
 */
@SpringBootApplication
@EnableCaching
public class BootDemoApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .allowCircularReferences(true)
                .sources(BootDemoApplication.class)
                .run(args);
    }
}
