package org.yqj.source.demo.net.netty.book.chart10.udp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import java.nio.charset.StandardCharsets;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019-06-18
 * Email: yaoqijunmail@foxmail.com
 */
public class ChineseClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String clientResponse = msg.content().toString(StandardCharsets.UTF_8);
        System.out.println("client response content is "  + clientResponse);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
