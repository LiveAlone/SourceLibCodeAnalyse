package org.yqj.source.demo.sentinel.controller;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/7/31
 * Email: yaoqijunmail@foxmail.com
 */
@Configuration
public class SentinelConfiguration {

    @PostConstruct
    public void init() {
        flowControllerInit();
    }

    private void flowControllerInit() {
        List<FlowRule> rules = new ArrayList<>();

        // single rule
        FlowRule rule = new FlowRule();
        rule.setResource("FlowController");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);

        rules.add(rule);

        FlowRuleManager.loadRules(rules);
    }
}
