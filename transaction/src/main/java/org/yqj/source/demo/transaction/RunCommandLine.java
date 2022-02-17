package org.yqj.source.demo.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yqj.source.demo.transaction.manager.CommonManager;
import org.yqj.source.demo.transaction.manager.Db1Manager;
import org.yqj.source.demo.transaction.manager.Db2Manager;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/8/15
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class RunCommandLine implements CommandLineRunner {

    @Autowired
    private CommonManager commonManager;

    @Autowired
    private Db1Manager db1Manager;

    @Autowired
    private Db2Manager db2Manager;

    public void run(String... args) {

//        db2Manager.updateDiffDbCondition();

//        commonManager.updateDiffDbCondition();

//        db1Manager.updateDiffDbConditionWithCallback();
//
        commonManager.printPersonContent();

//        log.info(" command info run");
    }
}
