package org.yqj.source.tool.basic.base.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/11/14
 * Email: yaoqijunmail@foxmail.com
 */
public class ThreadMain {

    public static void main(String[] args) throws Exception {
        tryToInterruptThread();
    }

    public static final void tryToInterruptThread() throws InterruptedException {
        // interrupt 执行中线程
//        Thread cur = new Thread(() -> {
//            long val = 0L;
//            try {
//                while (true) {
//                    val += 1;
//                }
//            }catch (Exception e) {
//                System.out.println("gain error message is " + e.getMessage());
//                System.out.println("exception value is :" + val);
//            }
//        });

        Thread cur = new Thread(()->{
            System.out.println("current thread is to starting");
            LockSupport.park();
            System.out.println("current thread is alive");
        });
        cur.start();
        Thread.sleep(10000);
        cur.interrupt();
        System.out.println("interrupt finish all");
    }

}
