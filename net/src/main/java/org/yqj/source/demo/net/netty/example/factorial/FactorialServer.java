package org.yqj.source.demo.net.netty.example.factorial;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.math.BigInteger;

/**
 * Created by yaoqijun on 2017/8/21.
 */
public class FactorialServer {

    public static void main(String[] args) {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new FactorialServerInitializer());

            b.bind(8080).sync().channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static class FactorialServerInitializer extends ChannelInitializer<SocketChannel>{

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
            channelPipeline.addLast(new FactorialServerHandler());
        }
    }

    public static class FactorialServerHandler extends SimpleChannelInboundHandler<BigInteger>{

        private BigInteger lastMultiplier = new BigInteger("1");

        private BigInteger factorial = new BigInteger("1");

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, BigInteger msg) throws Exception {
            lastMultiplier = msg;
            factorial = factorial.multiply(msg);
            ctx.writeAndFlush(factorial);
            System.out.printf("Factorial of %,d is: %,d%n", lastMultiplier, factorial);
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            System.out.printf("Factorial of %,d is: %,d%n", lastMultiplier, factorial);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }
}
