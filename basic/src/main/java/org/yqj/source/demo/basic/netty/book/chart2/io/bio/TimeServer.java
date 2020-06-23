package org.yqj.source.demo.basic.netty.book.chart2.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(port);
            System.out.println("time server listen to port " + port);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
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
