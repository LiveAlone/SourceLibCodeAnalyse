package org.yqj.source.demo.basic.netty.book2.chart2.nio;

/**
 * Created by yaoqijun on 2017/8/25.
 */
public class TimeServer {

    public static void main(String[] args) {

        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(9090);

        new Thread(multiplexerTimeServer, "NIO-MultipleServer-001").start();
    }
}
