package org.yqj.source.demo.spring;

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
//@EnableCaching
//@EnableAspectJAutoProxy
public class BootDemoApplication {
    public static void main(String[] args) {
//        String[] params = new String[]{"commandLineValue", "command_line_value"};
        String[] params = new String[]{};
        new SpringApplicationBuilder()
//                .allowCircularReferences(true)
                .sources(BootDemoApplication.class)
//                .applicationStartup(new FlightRecorderApplicationStartup())
                .run(params);
    }
}
