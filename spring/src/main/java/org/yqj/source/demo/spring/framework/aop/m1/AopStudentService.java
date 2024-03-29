package org.yqj.source.demo.spring.framework.aop.m1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/26
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class AopStudentService {

    public String saveStudent(AopStudent student) throws InterruptedException {
        int cost = ThreadLocalRandom.current().nextInt(1000);
        Thread.sleep(cost);
        log.info("save student success student:{}, cost:{}", student, cost);
        return "SUCCESS";
    }

    public AopStudent queryStudent(String name, int age, int score) throws InterruptedException {
        int cost = ThreadLocalRandom.current().nextInt(1000);
        Thread.sleep(cost);
        AopStudent student = new AopStudent(name, age, score);
        log.info("query student success student:{}, cost:{}", student, cost);
        return student;
    }
}
