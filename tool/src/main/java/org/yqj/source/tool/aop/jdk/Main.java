package org.yqj.source.tool.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/26
 * Email: yaoqijunmail@foxmail.com
 */
public class Main {

    public static void main(String[] args) throws Exception {
//        createInstanceWithInstance();

//        createInstanceWithClass();
    }

    public static void createInstanceWithClass() throws Exception{
        FooImpl impl = new FooImpl();
        Class proxyClass = Proxy.getProxyClass(impl.getClass().getClassLoader(), impl.getClass().getInterfaces());
        System.out.println(proxyClass.getName());
    }

    public static void createInstanceWithInstance() {
        FooImpl impl = new FooImpl();
        Object proxy = Proxy.newProxyInstance(impl.getClass().getClassLoader(), impl.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result;
                try {
                    System.out.println("before method " + method.getName());
                    result = method.invoke(impl, args);
                } catch (Exception e) {
                    throw new RuntimeException("unexpected invocation exception: " +
                            e.getMessage());
                } finally {
                    System.out.println("after method " + method.getName());
                }
                return result;
            }
        });

        Foo foo = (Foo) proxy;
        System.out.println(foo.hello("test"));
    }
}
