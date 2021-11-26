package org.yqj.source.demo.sw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/11/26
 * Email: yaoqijunmail@foxmail.com
 */
@RestController
public class PingController {

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String address() throws Exception {
        return InetAddress.getLocalHost().getHostAddress();
    }
}
