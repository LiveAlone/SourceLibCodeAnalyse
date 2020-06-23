package org.yqj.source.demo.basic.netty.example.factorial;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.math.BigInteger;

/**
 * Created by yaoqijun on 2017/8/21.
 */
public class NumberEncoder extends MessageToByteEncoder<Number> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Number msg, ByteBuf out) throws Exception {
        BigInteger v;

        if (msg instanceof BigInteger){
            v = (BigInteger) msg;
        }else {
            v = new BigInteger(String.valueOf(msg));
        }

        byte[] data = v.toByteArray();
        int dataLength = data.length;

        // write message
        out.writeByte('F');
        out.writeInt(dataLength);
        out.writeBytes(data);
    }
}
