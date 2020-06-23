package org.yqj.source.demo.basic.nio.basic2.nio;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019-06-14
 * Email: yaoqijunmail@foxmail.com
 */
public class TimeClient {

    public static void main(String[] args) throws Exception {
        new Thread(new TimeClientHandler("127.0.0.1", 8888)).start();
    }
}
