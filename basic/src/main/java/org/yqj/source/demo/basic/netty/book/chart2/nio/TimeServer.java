package org.yqj.source.demo.basic.netty.book.chart2.nio;

/**
 * Created by yaoqijun on 2017/8/25.
 */
public class TimeServer {

    public static void main(String[] args) {

        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(8080);

        new Thread(multiplexerTimeServer, "NIO-MultipleServer-001").start();
    }
}
