package org.yqj.source.demo.empty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/8/16
 * Email: yaoqijunmail@foxmail.com
 */
@RestController
@Slf4j
public class EmptyController {

    @RequestMapping(value = "/none")
    public String none(){
        log.info("empty none controller config");
        return "hello world";
    }
}
