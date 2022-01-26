package org.yqj.source.demo.spring.framework.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;
import org.yqj.source.demo.spring.framework.aop.service.DefaultPeopleEnabled;
import org.yqj.source.demo.spring.framework.aop.service.PeopleEnabled;

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

//    @DeclareParents(value = "org.yqj.source.demo.spring.framework.aop.service.*Service", defaultImpl = DefaultPeopleEnabled.class)
//    public PeopleEnabled peopleEnabled;

//    @Around(value = "execution(* org.yqj.source.demo.spring.framework.aop.service.AopUserService.saveUser(..))")
//    public void aroundSaveUser(ProceedingJoinPoint pjp) throws Throwable {
//        log.info("**** around process user before");
//        for (Object arg : pjp.getArgs()) {
//            log.info("1 args is :{}", arg);
//        }
//        log.info("2 ProceedingJoinPoint this is :{}", pjp.getThis());
//        log.info("3 ProceedingJoinPoint target is :{}", pjp.getTarget());
//        log.info("4 ProceedingJoinPoint getSignature is :{}", pjp.getSignature());
//        log.info("5 ProceedingJoinPoint string is :{}", pjp.toString());
//        pjp.proceed();
//        log.info("**** around process user after");
//    }

//    @AfterThrowing(value = "execution(* org.yqj.source.demo.spring.framework.aop.service.AopUserService.validateUser(..))", throwing = "ex")
//    public void throwInValidateUser(IllegalArgumentException ex) {
//        log.info("****** after throwing validate user", ex);
//    }

//    @Before("execution(* org.yqj.source.demo.spring.framework.aop.service.AopUserService.saveUser(..))")
//    public void beforeSaveUser() {
//        log.info("****** business trace before saveUser aspect");
//    }

//    @After(value = "execution(* org.yqj.source.demo.spring.framework.aop.service.AopUserService.saveUser(..))")
//    public void afterSaveUser() {
//        log.info("***** business trace after saveUser aspect");
//    }
//
//    @AfterReturning(value = "execution(* org.yqj.source.demo.spring.framework.aop.service.AopUserService.saveUser(..))", returning = "retVal")
//    public void afterReturningSaveUser(Object retVal) {
//        log.info("***** business trace after saveUser aspect, with ret val :{}", retVal);
//    }

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
