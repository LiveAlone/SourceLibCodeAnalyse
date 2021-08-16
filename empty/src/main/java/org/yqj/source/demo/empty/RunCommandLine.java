package org.yqj.source.demo.empty;

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
//@Slf4j
public class RunCommandLine implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("run command line starting ... ");
    }
}
