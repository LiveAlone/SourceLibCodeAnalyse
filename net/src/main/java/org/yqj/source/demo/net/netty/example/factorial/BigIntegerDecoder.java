package org.yqj.source.demo.net.netty.example.factorial;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by yaoqijun on 2017-09-01.
 */
public class BigIntegerDecoder extends ByteToMessageDecoder{
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if (in.readableBytes() < 5){
            return;
        }

        in.markReaderIndex();

        int magicNumber = in.readUnsignedByte();

        if (magicNumber != 'F'){
            in.resetReaderIndex();
            throw new CorruptedFrameException("Invalid magic number " + magicNumber);
        }


        int dataLength = in.readInt();

        if (in.readableBytes() < dataLength){
            in.resetReaderIndex();
            return;
        }

        byte[] decoded = new byte[dataLength];
        in.readBytes(decoded);
        out.add(new BigInteger(decoded));
    }
}
