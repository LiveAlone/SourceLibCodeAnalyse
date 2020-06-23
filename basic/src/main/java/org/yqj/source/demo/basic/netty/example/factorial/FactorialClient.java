package org.yqj.source.demo.basic.netty.example.factorial;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by yaoqijun on 2017-09-01.
 */
public class FactorialClient {

    public static int COUNT = 100;

    public static void main(String[] args) {
        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new FacorialClientInitializer());

            // Start the client.
            ChannelFuture f = b.connect("localhost", 8080).sync();

            FactorialClientHandler handler =
                    (FactorialClientHandler) f.channel().pipeline().last();

            // Print out the answer.
            System.err.format("Factorial of %,d is: %,d", COUNT, handler.getFactorial());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }
    }

    public static class FacorialClientInitializer extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ChannelPipeline channelPipeline = ch.pipeline();

            // enable compress encoder decoder config
            channelPipeline.addLast(ZlibCodecFactory.newZlibEncoder(ZlibWrapper.GZIP));
            channelPipeline.addLast(ZlibCodecFactory.newZlibDecoder(ZlibWrapper.GZIP));

            // add number code first
            channelPipeline.addLast(new BigIntegerDecoder());
            channelPipeline.addLast(new NumberEncoder());

            // add handler
            channelPipeline.addLast(new FactorialClientHandler());
        }
    }

    public static class FactorialClientHandler extends SimpleChannelInboundHandler<BigInteger>{

        private ChannelHandlerContext ctx;
        private int receivedMessages;
        private int next = 1;
        final BlockingQueue<BigInteger> answer = new LinkedBlockingQueue<BigInteger>();

        public BigInteger getFactorial() {
            boolean interrupted = false;
            try {
                for (;;) {
                    try {
                        return answer.take();
                    } catch (InterruptedException ignore) {
                        interrupted = true;
                    }
                }
            } finally {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) {
            this.ctx = ctx;
            sendNumbers();
        }

        @Override
        public void channelRead0(ChannelHandlerContext ctx, final BigInteger msg) {
            receivedMessages ++;
            if (receivedMessages == FactorialClient.COUNT) {
                // Offer the answer after closing the connection.
                ctx.channel().close().addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future) {
                        boolean offered = answer.offer(msg);
                        assert offered;
                    }
                });
            }
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            ctx.close();
        }

        private void sendNumbers() {
            // Do not send more than 4096 numbers.
            ChannelFuture future = null;
            for (int i = 0; i < 4096 && next <= FactorialClient.COUNT; i++) {
                future = ctx.write(Integer.valueOf(next));
                next++;
            }
            if (next <= FactorialClient.COUNT) {
                assert future != null;
                future.addListener(numberSender);
            }
            ctx.flush();
        }

        private final ChannelFutureListener numberSender = future -> {
            if (future.isSuccess()) {
                sendNumbers();
            } else {
                future.cause().printStackTrace();
                future.channel().close();
            }
        };
    }

}
