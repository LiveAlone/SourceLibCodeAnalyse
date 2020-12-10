package org.yqj.source.demo.actuator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/12/10
 * Email: yaoqijunmail@foxmail.com
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
