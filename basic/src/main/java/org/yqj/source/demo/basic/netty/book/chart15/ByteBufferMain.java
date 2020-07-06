package org.yqj.source.demo.basic.netty.book.chart15;

import java.nio.ByteBuffer;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/7/2
 * Email: yaoqijunmail@foxmail.com
 */
public class ByteBufferMain {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        String value = "netty hello world ha !!";
        byteBuffer.put(value.getBytes());
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes));
    }
}
