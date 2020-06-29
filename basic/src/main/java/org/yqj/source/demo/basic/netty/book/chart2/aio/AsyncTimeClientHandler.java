package org.yqj.source.demo.basic.netty.book.chart2.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeClientHandler implements CompletionHandler<Void, AsyncTimeClientHandler>, Runnable{

    private String host;

    private int port;

    private AsynchronousSocketChannel channel;

    private CountDownLatch latch;

    public AsyncTimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            channel = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        latch = new CountDownLatch(1);

        channel.connect(new InetSocketAddress(host, port), this, this);
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        try {
            channel.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        byte[] writeString = "query time ordered".getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(writeString.length);
        byteBuffer.put(writeString);
        byteBuffer.flip();
        channel.write(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if (attachment.hasRemaining()){
                    channel.write(attachment, attachment, this);
                }else {
                    ByteBuffer reader = ByteBuffer.allocate(1024);
                    channel.read(reader, reader, new CompletionHandler<Integer, ByteBuffer>() {

                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            byte[] bytes = new byte[attachment.remaining()];
                            attachment.get(bytes);
                            String body;
                            try {
                                body = new String(bytes, "UTF-8");
                                System.out.println("body is " + body);
                                latch.countDown();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                channel.close();
                                latch.countDown();
                            }catch (IOException e){}
                        }
                    });
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    channel.close();
                    latch.countDown();
                }catch (IOException e){}
            }
        });
    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        exc.printStackTrace();

        try {
            channel.close();
            latch.countDown();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
