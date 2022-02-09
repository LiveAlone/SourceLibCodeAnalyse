package org.yqj.source.tool.aop.asm;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/28
 * Email: yaoqijunmail@foxmail.com
 */
public class TestClass {

    public static final int test_constant_value = 9999;

    public static int m = 666;

    public TestClass() throws RuntimeException {}

    public TestClass(String name) throws Exception {}

    public void onlyMe(String test) {
        synchronized (test) {
            System.out.println("current only me");
        }
    }

    public int inc() {
        try {
            Thread.sleep(1000);
        }catch (IllegalStateException e){
        }catch (Exception e) {
        }
        return m + 1;
    }

    public int exp() {
        int x = 1;

        try {
            x = 2;
            return x;
        }catch (Exception e) {
            x = 3;
            return x;
        }finally {
            x = 4;
        }
    }
}
