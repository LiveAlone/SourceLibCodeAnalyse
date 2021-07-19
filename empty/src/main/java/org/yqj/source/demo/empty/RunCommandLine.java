package org.yqj.source.demo.empty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        int a = 100;
        for (int i = 0; i < 10; i++) {
            a += 1;
        }
        System.out.println(a);
    }
}
