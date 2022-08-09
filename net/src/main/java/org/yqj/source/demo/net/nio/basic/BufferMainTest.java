package org.yqj.source.demo.net.nio.basic;

import java.nio.CharBuffer;

/**
 * @author yaoqijun on 2018-05-21.
 */
public class BufferMainTest {
    public static void main(String[] args) {
        String source = "sourceContent proto";

        CharBuffer charBuffer = CharBuffer.allocate(100);

        for (int i = 0; i < source.length(); i++){
            charBuffer.put(source.charAt(i));
        }

        charBuffer.flip();

        while (charBuffer.hasRemaining()){
            System.out.println(charBuffer.get());
        }

        charBuffer.clear();
    }
}
