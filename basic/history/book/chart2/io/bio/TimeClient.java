package org.yqj.source.demo.basic.netty.book.chart2.io.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        int port = 1234;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("localhost", port);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("query time order");
            System.out.println("client to receiver ");
            String resp = in.readLine();
            System.out.println("response is " + resp);
        }catch (Exception e){

        }finally {
            if (in != null){
                try {
                    in.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
            in = null;

            if (out != null){
                out.close();
                out = null;
            }

            if (socket != null){
                try {
                    socket.close();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
                socket = null;
            }
        }

    }
}
