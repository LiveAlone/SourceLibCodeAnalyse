package org.yqj.source.demo.basic.netty.book.chart2.aio;

public class TimeClient {
    public static void main(String[] args) {
        new Thread(new AsyncTimeClientHandler("localhost", 1234), "AsyncTimeClientHandler").start();
    }
}
