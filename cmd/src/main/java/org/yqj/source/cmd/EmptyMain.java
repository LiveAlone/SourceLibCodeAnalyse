package org.yqj.source.cmd;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/5/21
 * Email: yaoqijunmail@foxmail.com
 */
@Slf4j
public class EmptyMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(100);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t1.start();
        System.out.println(t1.getName() + "-" + t1.getThreadGroup().getName());
    }


}
