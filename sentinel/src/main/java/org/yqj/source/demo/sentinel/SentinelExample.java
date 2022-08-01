package org.yqj.source.demo.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019/11/5
 * Email: yaoqijunmail@foxmail.com
 */
public class SentinelExample {

    public static void main(String[] args) throws Exception {
        init();

        limitDemo();
    }

    public static void limitDemo() throws Exception {
        while (true) {
            try (Entry entry = SphU.entry("HelloWorld")) {
                System.out.println("Hello world !!");
            } catch (Exception e) {
            }
            Thread.sleep(10);
        }
    }

    public static void differentEntryConfig() throws BlockException {
        ContextUtil.enter("entrance1", "appA");
        Entry nodeA = SphU.entry("nodeA");
        if (nodeA != null) {
            nodeA.exit();
        }
        ContextUtil.exit();

        ContextUtil.enter("entrance2", "appA");
        nodeA = SphU.entry("nodeA");
        if (nodeA != null) {
            nodeA.exit();
        }
        ContextUtil.exit();
    }

    public static void testSphOTest(){
        while (true){
            if (SphO.entry("HelloWorld")){
                try {
                    System.out.println("hello world! ");
                }finally {
                    SphO.exit();
                }
            }else {
                System.out.println("block");
            }
        }
    }

    public static void init() {
        List<FlowRule> rules = new ArrayList<>();

        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(10);      // qps 数量限制

        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
