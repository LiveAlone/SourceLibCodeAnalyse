package org.yqj.source.demo.basic.netty.book.chart4.tcpnew;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.joda.time.DateTime;

/**
 * Created by yaoqijun on 2017/8/26.
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String body = (String) msg;

        System.out.println("current read count is " + body + ", counter :" + ++counter);

        ctx.writeAndFlush(Unpooled.copiedBuffer((DateTime.now().toString()+ "\n").getBytes()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
