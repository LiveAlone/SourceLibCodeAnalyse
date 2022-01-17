package org.yqj.source.demo.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
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
        String[] params = new String[]{"commandLineValue", "command_line_value"};
        new SpringApplicationBuilder()
                .allowCircularReferences(true)
                .sources(BootDemoApplication.class)
                .applicationStartup(new BufferingApplicationStartup(Integer.MAX_VALUE))
                .run(params);
    }
}
