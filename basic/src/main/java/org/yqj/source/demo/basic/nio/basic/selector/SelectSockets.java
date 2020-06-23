package org.yqj.source.demo.basic.nio.basic.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectSockets {

    private static final int SERVER_PORT = 1234;

    private ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

    public static void main(String[] args) throws Exception {
        new SelectSockets().go();
    }

    public void go() throws Exception{
        // open channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket serverSocket = serverSocketChannel.socket();

        // selector
        Selector selector = Selector.open();

        serverSocket.bind(new InetSocketAddress(SERVER_PORT));
        serverSocketChannel.configureBlocking(false);

        // register selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            int n = selector.select();
            if (n == 0){
                continue;
            }

            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext()){
                SelectionKey selectionKey = it.next();

                if (selectionKey.isAcceptable()){
                    // accept content
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = server.accept();
                    registerChannel(selector, socketChannel, SelectionKey.OP_READ);
                    sayHello(socketChannel);
                }

                if (selectionKey.isReadable()){
                    // read content
                    readDataFromSocket(selectionKey);
                }

                // remove content
                it.remove();
            }
        }


    }

    private void readDataFromSocket(SelectionKey selectionKey) throws IOException{

        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        int count;

        while ((count = socketChannel.read(byteBuffer))>0){
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()){
                socketChannel.write(byteBuffer);
            }
            byteBuffer.clear();
        }

        if (count < 0){
            socketChannel.close();
        }
    }

    private void sayHello(SocketChannel channel) throws IOException {
        byteBuffer.clear();
        byteBuffer.put("hi there \r\n".getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);
    }

    protected void registerChannel(Selector selector, SelectableChannel selectableChannel, int ops) throws IOException {
        if (selectableChannel == null){
            return;
        }
        selectableChannel.configureBlocking(true);
        selectableChannel.register(selector, ops);
    }

}
