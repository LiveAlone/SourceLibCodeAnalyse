package org.yqj.source.demo.net.netty.example.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by yaoqijun on 2017/8/20.
 */
public class DiscardClientHandler extends SimpleChannelInboundHandler<Object>{

    private ByteBuf content;

    private ChannelHandlerContext ctx;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;

        content = ctx.alloc().directBuffer(256).writeZero(256);

        generateTraffic();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        content.release();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        // server is support nothing
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private void generateTraffic(){
        this.ctx.writeAndFlush(content.retainedDuplicate()).addListener(trafficListener);
    }

    private final ChannelFutureListener trafficListener = (future) -> {
            if (future.isSuccess()){
                generateTraffic();
            }else {
                future.cause().printStackTrace();
                future.channel().close();
            }
    };
}
