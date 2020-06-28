package org.yqj.source.demo.basic.netty.book.chart2.io.abio;

import org.yqj.source.demo.basic.netty.book.chart2.io.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServerWithPool {

    public static void main(String[] args) throws IOException {
        int port = 1234;
        TimeServerHandlerExecutePool pool = new TimeServerHandlerExecutePool(10);

        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(port);
            System.out.println("time server listen to port " + port);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                pool.execute(new TimeServerHandler(socket));
            }
        }finally {
            if (serverSocket != null){
                System.out.println("to close server socket content");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }

}
