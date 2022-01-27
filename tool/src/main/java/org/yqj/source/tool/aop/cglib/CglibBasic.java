package org.yqj.source.tool.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/26
 * Email: yaoqijunmail@foxmail.com
 */
public class CglibBasic {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom!");
        PersonService proxy = (PersonService) enhancer.create();

        System.out.println(proxy.sayHello(null));
        System.out.println(proxy.lengthOfName("wtf"));
    }
}
