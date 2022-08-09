package org.yqj.source.demo.net.nio.basic;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * @author yaoqijun on 2018-05-22.
 */
public class MappedByteBufferMainTest {
    public static void main(String[] args) throws IOException {

        File templateFile = new File("mmaptest.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(templateFile, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer temp = ByteBuffer.allocate(100);

        temp.put("0123456789".getBytes());
        temp.flip();
        fileChannel.write(temp, 0);

        temp.clear();
        temp.put("9876543210".getBytes());
        temp.flip();
        fileChannel.write(temp, 20);

        MappedByteBuffer ro = fileChannel.map(MapMode.READ_ONLY, 0, fileChannel.size());
        MappedByteBuffer rw = fileChannel.map(MapMode.READ_WRITE, 0, fileChannel.size());
        MappedByteBuffer cow = fileChannel.map(MapMode.PRIVATE, 0, fileChannel.size());

        System.out.println("begin");
        showBuffers(ro, rw, cow);

        cow.position(8);
        cow.put("CO".getBytes());
        System.out.println("change cow buffer content");
        showBuffers(ro, rw, cow);

        rw.position(1);
        rw.put("RW".getBytes());
        rw.position(21);
        rw.put("RW".getBytes());
        rw.force();
        System.out.println("change RW buffer content");
        showBuffers(ro, rw, cow);

        // tmp
        temp.clear();
        temp.put("ABCDEFGHIJ".getBytes());
        temp.flip();
        fileChannel.write(temp, 0);
        temp.rewind();
        fileChannel.write(temp, 20);
        System.out.println("write to channel");
        showBuffers(ro, rw, cow);

        //
        cow.position(22);
        cow.put("222".getBytes());
        System.out.println("second update cow2 content");
        showBuffers(ro, rw, cow);

        rw.position(0);
        rw.put("RW2".getBytes());
        rw.position(22);
        rw.put("RW2".getBytes());
        rw.force();
        System.out.println("change RW2 buffer content");
        showBuffers(ro, rw, cow);

        fileChannel.close();
        randomAccessFile.close();
        templateFile.delete();
    }

    private static void showBuffers(MappedByteBuffer ro, MappedByteBuffer rw, MappedByteBuffer cow){
        dumpBuffer("RO ", ro);
        dumpBuffer("RW ", rw);
        dumpBuffer("CO ", cow);
        System.out.println("");
    }

    private static void dumpBuffer(String prefix, MappedByteBuffer byteBuffer){
        System.out.print(prefix + " : '");
        int nulls = 0;
        int limit = byteBuffer.limit();
        for (int i=0; i<limit; i++){
            char c = (char) byteBuffer.get(i);
            if (c == '\u0000'){
                nulls ++;
                continue;
            }
            if (nulls!=0){
                System.out.print("[ nulls count is : "+ nulls +" ]");
                nulls = 0;
            }
            System.out.print(c);
        }
        System.out.println("'");
    }
}
