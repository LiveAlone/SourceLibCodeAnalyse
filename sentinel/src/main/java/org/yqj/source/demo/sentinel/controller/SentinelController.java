package org.yqj.source.demo.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/7/31
 * Email: yaoqijunmail@foxmail.com
 */
@RestController
@Slf4j
public class SentinelController {

    @RequestMapping(value = "flow", method = RequestMethod.GET)
    public String flowController() {
        try (Entry entry = SphU.entry("FlowController")) {
            Thread.sleep(ThreadLocalRandom.current().nextInt(300));
            return "success";
        } catch (Exception e) {
            log.error("flow controller fail cause:", e);
            return e.toString();
        }
    }
}
