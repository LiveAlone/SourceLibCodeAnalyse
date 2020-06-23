package org.yqj.source.demo.basic.netty.book.chart2.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by yaoqijun on 2017/8/26.
 */
public class AsyncTimeServerHandler implements Runnable {

    private int port;

    CountDownLatch countDownLatch;

    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncTimeServerHandler(int port) {
        this.port = port;
        try {
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();

            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("server init error");
        }
    }

    @Override
    public void run() {
        countDownLatch = new CountDownLatch(1);

        doAccept();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("thread interrupted exception");
        }

    }

    private void doAccept(){
        asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
    }
}
