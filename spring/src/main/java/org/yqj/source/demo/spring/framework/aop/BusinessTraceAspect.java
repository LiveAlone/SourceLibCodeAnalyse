package org.yqj.source.demo.spring.framework.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/26
 * Email: yaoqijunmail@foxmail.com
 */
@Aspect
@Component
@Slf4j
public class BusinessTraceAspect {

    @Before("execution(* org.yqj.source.demo.spring.framework.aop.service.AopUserService.saveUser(..))")
    public void beforeSaveUser() {
        log.info("****** business trace before saveUser aspect");
    }

    @After("execution(* org.yqj.source.demo.spring.framework.aop.service.AopUserService.saveUser(..))")
    public void afterSaveUser() {
        log.info("***** business trace after saveUser aspect");
    }

//    @Pointcut("execution(* org.yqj.source.demo.spring.framework.aop.service.AopUserService.saveUser(..))")
//    @Pointcut("execution(* org.yqj.source.demo.spring.framework.aop.service.AopStudentService.*(..))")
//    @Pointcut("within(org.yqj.source.demo.spring.framework.aop.service.AopUserService)")
//    @Pointcut("this(org.yqj.source.demo.spring.framework.aop.service.AopUserService)")
//    public void pointCutExpressTest() {
//    }

//    @Before("pointCutExpressTest()")
//    public void beforePointCutTest() {
//        log.info("******** before trace point cut test");
//    }
}
