package org.yqj.source.demo.sentinel;

import com.alibaba.csp.sentinel.AsyncEntry;
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

    public static void main(String[] args) throws Exception{
        initFlowRules();
        helloWorld();
    }

    private static void helloWorld() throws Exception{
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("HelloWorld");
                System.out.println("Hello world !!");
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("block!");
                Thread.sleep(1000);
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }

//        while (true){
//            try(Entry entry = SphU.entry("HelloWorld")) {
//                System.out.println("Hello world !!");
//            }catch (Exception e){
//                System.out.println("block");
//            }
//        }
    }

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(5);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    public static void differentEntryConfig() throws BlockException{
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

    public static void asyncEntryTest() {
        AsyncEntry asyncEntry = null;

        try {
            asyncEntry = SphU.asyncEntry("HelloWorld");
        } catch (BlockException e) {
            System.out.println("block config !");
        }
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
}
