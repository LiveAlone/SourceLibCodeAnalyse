package org.yqj.source.tool.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.yqj.source.tool.aop.cglib.CglibBasic;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/27
 * Email: yaoqijunmail@foxmail.com
 */
@Slf4j
public class CglibBasicTest {

    @Test
    public void superMethodExecuteTest() {
        CglibBasic.superMethodExecute();
    }

    @Test
    public void animalInterfaceProxyTest() {
        CglibBasic.animalInterfaceProxy();
    }

    @Test
    public void personServiceProxyTest(){
        CglibBasic.personServiceProxy();
    }
}
