package org.yqj.source.demo.net.netty.example.file;

import com.google.common.base.Charsets;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedFile;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.io.RandomAccessFile;

/**
 * Created by yaoqijun on 2017-09-01.
 */
public class FileServer {

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();

                            p.addLast(new StringEncoder(Charsets.UTF_8),
                                    new LineBasedFrameDecoder(8192),
                                    new StringDecoder(Charsets.UTF_8),
                                    new ChunkedWriteHandler(),
                                    new FileServerHandler()
                            );
                        }
                    });

            // Start the server.
            ChannelFuture f = b.bind(8080).sync();

            // Wait until the server socket is closed.
            f.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // Shut down all event loops to terminate all threads.
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static final class FileServerHandler extends SimpleChannelInboundHandler<String>{

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            ctx.writeAndFlush("HELLO: Type the path of the file to retrieve.\n");
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();

            if (ctx.channel().isActive()) {
                ctx.writeAndFlush("ERR: " +
                        cause.getClass().getSimpleName() + ": " +
                        cause.getMessage() + '\n').addListener(ChannelFutureListener.CLOSE);
            }
        }

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
            RandomAccessFile raf = null;
            long length = -1;
            try {
                raf = new RandomAccessFile(msg, "r");
                length = raf.length();
            } catch (Exception e) {
                ctx.writeAndFlush("ERR: " + e.getClass().getSimpleName() + ": " + e.getMessage() + '\n');
                return;
            } finally {
                if (length < 0 && raf != null) {
                    raf.close();
                }
            }

            ctx.write("OK: " + raf.length() + '\n');
            if (ctx.pipeline().get(SslHandler.class) == null) {
                // SSL not enabled - can use zero-copy file transfer.
                ctx.write(new DefaultFileRegion(raf.getChannel(), 0, length));
            } else {
                // SSL enabled - cannot use zero-copy file transfer.
                ctx.write(new ChunkedFile(raf));
            }
            ctx.writeAndFlush("\n");
        }
    }
}
