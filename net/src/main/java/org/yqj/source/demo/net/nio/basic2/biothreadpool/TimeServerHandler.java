package org.yqj.source.demo.net.nio.basic2.biothreadpool;

import org.joda.time.DateTime;

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
public class TimeServerHandler implements Runnable{

    private Socket socket;

    private int count = 0;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if (body == null){
                    break;
                }
                System.out.println("The time server receive order : " + body);
                System.out.println("current thread name is content : " + Thread.currentThread().getName() + ", count: " + count++);
                currentTime = "QUERY TIME ORDER".equals(body) ? DateTime.now().toString() : "BAD ORDER";
                out.println(currentTime);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("finish all content over");
            if (in != null){
                try {
                    in.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
            if (out != null){
                out.close();
                out = null;
            }
            if (this.socket!=null){
                try {
                    this.socket.close();
                }catch (Exception e1){
                    e.printStackTrace();
                }
                this.socket = null;
            }
        }
    }
}
