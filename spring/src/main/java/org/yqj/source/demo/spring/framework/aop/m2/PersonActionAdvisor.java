package org.yqj.source.demo.spring.framework.aop.m2;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/29
 * Email: yaoqijunmail@foxmail.com
 */
//@Component
@Slf4j
public class PersonActionAdvisor extends AbstractPointcutAdvisor {
    @Override
    public Pointcut getPointcut() {
        return new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                if (Runner.class.isAssignableFrom(targetClass)) {
                    return true;
                }
                return false;
            }
        };
    }

    @Override
    public Advice getAdvice() {
        return new MethodInterceptor() {
            @Nullable
            @Override
            public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
                log.info("********** before running prepare");
                Object result = invocation.proceed();
                log.info("********** after running prepare");
                return result;
            }
        };
    }
}
