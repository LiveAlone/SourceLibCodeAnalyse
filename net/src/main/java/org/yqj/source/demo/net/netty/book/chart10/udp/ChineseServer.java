package org.yqj.source.demo.net.netty.book.chart10.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019-06-18
 * Email: yaoqijunmail@foxmail.com
 */
public class ChineseServer {

    public void run(int port) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChineseServerHandler());
            bootstrap.bind(port).sync().channel().closeFuture().await();

        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new ChineseServer().run(8080);
    }
}
