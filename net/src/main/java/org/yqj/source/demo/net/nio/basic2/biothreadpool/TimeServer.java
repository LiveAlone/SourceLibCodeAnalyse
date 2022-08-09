package org.yqj.source.demo.net.nio.basic2.biothreadpool;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019-06-14
 * Email: yaoqijunmail@foxmail.com
 */
public class TimeServer {

    public static void main(String[] args) throws Exception{

        ServerSocket server = null;

        try {
            server = new ServerSocket(8888);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }finally {
            if (server != null){
                server.close();
                server = null;
            }
        }
    }
}
