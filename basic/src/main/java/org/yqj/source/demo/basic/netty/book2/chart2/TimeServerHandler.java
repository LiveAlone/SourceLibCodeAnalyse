package org.yqj.source.demo.basic.netty.book2.chart2;

import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/6/28
 * Email: yaoqijunmail@foxmail.com
 */
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            while (true){
                String line = in.readLine();
                if (line == null){
                    break;
                }
                System.out.println("time server receive line content is " + line);
                out.println(DateTime.now().toString());
            }

        }catch (Exception e){
            System.out.println("catch exception");
            e.printStackTrace();
        }finally {
            System.out.println("to close all");
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }

            if (out != null){
                out.close();
                out = null;
            }

            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.socket = null;

        }
    }
}
