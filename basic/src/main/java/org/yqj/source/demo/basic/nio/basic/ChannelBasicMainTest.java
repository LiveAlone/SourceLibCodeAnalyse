package org.yqj.source.demo.basic.nio.basic;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelBasicMainTest {

    public static void main(String[] args) throws IOException {
        ReadableByteChannel readableByteChannel = Channels.newChannel(System.in);

        WritableByteChannel writableByteChannel = Channels.newChannel(System.out);

//        channelCopy1(readableByteChannel, writableByteChannel);

        channelCopy2(readableByteChannel, writableByteChannel);

        readableByteChannel.close();

        writableByteChannel.close();
    }

    // 也许一次没有写完, 通过压缩方式， 写入下一次。
    public static void channelCopy1(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16 * 1024);

        while (src.read(byteBuffer)!=-1){
            byteBuffer.flip();
            dest.write(byteBuffer);
            byteBuffer.compact();
        }
        byteBuffer.flip();

        while (byteBuffer.hasRemaining()){
            dest.write(byteBuffer);
        }
    }

    // 每一次确认写完以后， clear 清除写入记录， 重新读取数据内容。
    public static void channelCopy2(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16 * 1024);

        while (src.read(byteBuffer)!=-1){
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                dest.write(byteBuffer);
            }
            byteBuffer.clear();
        }
    }
}
