package org.yqj.source.demo.net.nio.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;

/**
 * @author yaoqijun on 2018-05-22.
 */
public class GatherMainTest {

    private static final String outputPath = "test.txt";

    private static String[] basics = {"first", "second", "third", "fourth", "five"};

    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(outputPath);

        GatheringByteChannel channel = fileOutputStream.getChannel();

        ByteBuffer[] byteBuffers = new ByteBuffer[5];

        for (int i=0; i<5; i++){
            ByteBuffer byteBuffer = ByteBuffer.allocate(50);
            byteBuffer.put(basics[i].getBytes());
            byteBuffer.flip();
            byteBuffers[i] = byteBuffer;
        }

        channel.write(byteBuffers);
    }

}
