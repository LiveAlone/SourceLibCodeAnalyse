package org.yqj.source.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.security.SecurityDataConfiguration;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

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

    public static void main(String[] args) {
        Class clazza = SecurityDataConfiguration.class;
        for (Annotation annotation : clazza.getAnnotations()) {
            System.out.println(annotation);
        }
    }
}
