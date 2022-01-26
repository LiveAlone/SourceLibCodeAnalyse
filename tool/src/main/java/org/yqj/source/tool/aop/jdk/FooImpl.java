package org.yqj.source.tool.aop.jdk;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/26
 * Email: yaoqijunmail@foxmail.com
 */
public class FooImpl implements Foo{
    @Override
    public String hello(String name) {
        return "world";
    }
}
