package org.yqj.source.demo.net.nio.basic2.nio;

import org.joda.time.DateTime;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019-06-14
 * Email: yaoqijunmail@foxmail.com
 */
public class MultiplexerTimeServer implements Runnable{

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    public MultiplexerTimeServer(int port) throws Exception{
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port : " + port);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    private void handleInput(SelectionKey selectionKey) throws IOException{
        if (selectionKey.isValid()){
            if (selectionKey.isAcceptable()){
                // 完成握手后处理
                ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }

            if (selectionKey.isReadable()){
                // 进行数据的读取写入方式
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int readBytes = socketChannel.read(byteBuffer);
                if (readBytes > 0){
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);
                    System.out.println("time server receive body is : " + body);
                    String currentTime = "QUERY TIME ORDER".equals(body) ? DateTime.now().toString() + "123\n" : "BAD REQUEST";
                    doWrite(socketChannel, currentTime);
                }else if (readBytes < 0){
                    selectionKey.cancel();
                    socketChannel.close();
                }else {
                    // 0 ignore
                }
            }
        }
    }

    private void doWrite(SocketChannel socketChannel, String response) throws IOException{
        if (response != null && response.trim().length() > 0){
            byte[] bytes = response.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
        }
    }

    @Override
    public void run() {
        while (!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                SelectionKey key = null;
                while (selectionKeyIterator.hasNext()){
                    key = selectionKeyIterator.next();
                    selectionKeyIterator.remove();
                    try {
                        handleInput(key);
                    }catch (Exception e1){
                        e1.printStackTrace();
                        if (key != null){
                            key.cancel();
                            if (key.channel()!=null){
                                key.channel().close();
                            }
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if (selector != null){
            try {
                selector.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        this.stop = true;
    }
}
