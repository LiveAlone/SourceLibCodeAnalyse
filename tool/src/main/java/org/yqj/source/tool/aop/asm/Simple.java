package org.yqj.source.tool.aop.asm;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/27
 * Email: yaoqijunmail@foxmail.com
 */
public class Simple {

    public static int sum() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}
