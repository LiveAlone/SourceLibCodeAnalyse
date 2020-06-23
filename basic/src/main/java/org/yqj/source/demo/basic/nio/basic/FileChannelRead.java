package org.yqj.source.demo.basic.nio.basic;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yaoqijun on 2017-09-04.
 */
public class FileChannelRead {
    public static void main(String[] args) throws Exception{
        RandomAccessFile accessFile = new RandomAccessFile("pom.xml", "rw");

        FileChannel fileChannel = accessFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = fileChannel.read(buf);

        while (bytesRead != -1) {
//            System.out.println("Read " + bytesRead);

            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();

            bytesRead = fileChannel.read(buf);
        }
        accessFile.close();
    }
}
