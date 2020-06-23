package org.yqj.source.demo.basic.netty.book.chart6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019-06-17
 * Email: yaoqijunmail@foxmail.com
 */
public class InfoReqServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        UserInfo userInfo = (UserInfo) msg;
        System.out.println("server get user info is : " + userInfo);
        userInfo.setAge(0);
        userInfo.setScore(666.666);
        ctx.writeAndFlush(userInfo);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
