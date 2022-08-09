package org.yqj.source.demo.net.netty.book.chart2.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by yaoqijun on 2017/8/26.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel channel){
        this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);

        try {
            String req = new String(body, "UTF-8");
            System.out.println("time server receiver is "+ req);

            String currentTime = "this is current time";

            doWrite(currentTime);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void doWrite(String currentTime){
        byte[] bytes = currentTime.getBytes();

        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);

        byteBuffer.put(bytes);

        byteBuffer.flip();

        channel.write(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if (attachment.hasRemaining()){
                    channel.write(attachment, attachment, this);
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    channel.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
