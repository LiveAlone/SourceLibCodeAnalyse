package org.yqj.source.demo.basic.nio.basic2.biothreadpool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019-06-14
 * Email: yaoqijunmail@foxmail.com
 */
public class TimeClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("QUERY TIME ORDER");
            System.out.println("request send content");
            System.out.println("response is " + in.readLine());

            out.println("QUERY TIME ORDER2");
            System.out.println("request send content");
            System.out.println("response is " + in.readLine());

            out.close();
            in.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
