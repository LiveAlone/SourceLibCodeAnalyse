package org.yqj.source.demo.empty;

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
public class EmptyController {

    @RequestMapping(value = "/none")
    public String none(){
        return "hello world";
    }
}
