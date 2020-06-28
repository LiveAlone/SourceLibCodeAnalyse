package org.yqj.source.demo.basic.netty.book2.chart2.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/6/28
 * Email: yaoqijunmail@foxmail.com
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8080);
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null){
                System.out.println("server socket to closed config");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
