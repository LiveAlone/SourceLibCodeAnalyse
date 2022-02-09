package org.yqj.source.demo.spring.framework.aop.m2;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/29
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Aspect
@Slf4j
public class PersonActionAspect {

//    @Before("execution(* org.yqj.source.demo.spring.framework.aop.m2.Runner.run(..))")
//    public void beforeRunnerAction() {
//        log.info("******** person action runner before");
//    }

}
