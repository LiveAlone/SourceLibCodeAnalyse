package org.yqj.source.demo.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.CircuitBreakerStrategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description: 鉴权规则监控支持
 *
 * @author yaoqijun
 * @date 2022/8/4
 * Email: yaoqijunmail@foxmail.com
 */
@Slf4j
public class AuthorityTest {

    @BeforeAll
    public static void initTest() {
        AuthorityRule rule = new AuthorityRule();
        rule.setResource("AuthorityController");
        rule.setStrategy(RuleConstant.AUTHORITY_WHITE);
        rule.setLimitApp("yao,qi,jun");
        AuthorityRuleManager.loadRules(Collections.singletonList(rule));
    }

    @Test
    public void singleTest() {
        ContextUtil.enter("default", "yao");
        try (Entry entry = SphU.entry("AuthorityController")) {
            Thread.sleep(ThreadLocalRandom.current().nextInt(300));
            log.info("request success");
        } catch (Throwable t) {
            log.error("authority controller fail cause:", t);
//            if (!BlockException.isBlockException(t)) {
//                Tracer.trace(t);
//            }
        }
    }
}
