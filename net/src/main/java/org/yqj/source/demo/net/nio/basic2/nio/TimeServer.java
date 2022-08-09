package org.yqj.source.demo.net.nio.basic2.nio;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019-06-14
 * Email: yaoqijunmail@foxmail.com
 */
public class TimeServer {

    public static void main(String[] args) throws Exception {
        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(8888);
        new Thread(multiplexerTimeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
