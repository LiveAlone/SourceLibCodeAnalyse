package org.yqj.source.demo.basic.netty.book.chart2.nio;

/**
 * Created by yaoqijun on 2017/8/26.
 */
public class TimeClient {
    public static void main(String[] args) {
        new Thread(new TimeClientHandler("localhost", 9090), "TimeClient-001").start();
    }
}
