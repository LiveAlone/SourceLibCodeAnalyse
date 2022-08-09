package org.yqj.source.demo.net.netty.book.chart2.aio;

/**
 * Created by yaoqijun on 2017/8/26.
 */
public class TimeServer {
    public static void main(String[] args) {
        System.out.println("start time server");

        AsyncTimeServerHandler handler = new AsyncTimeServerHandler(1234);

        new Thread(handler, "AIO-AsyncTimeServerHandler-001").start();
    }
}
