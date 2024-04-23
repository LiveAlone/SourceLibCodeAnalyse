package org.yqj.source.demo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/8/15
 * Email: yaoqijunmail@foxmail.com
 */
@SpringBootApplication
@EnableDubbo
public class BootDemoApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(BootDemoApplication.class)
                .run(args);
    }
}
