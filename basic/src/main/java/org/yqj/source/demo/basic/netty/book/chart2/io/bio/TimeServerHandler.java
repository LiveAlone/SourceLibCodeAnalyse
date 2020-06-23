package org.yqj.source.demo.basic.netty.book.chart2.io.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable{

    private Socket socket;

    public TimeServerHandler(Socket socket){
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
                System.out.println("time server received body is : " + body);
                out.println("current time is : " + String.valueOf(new Date().getTime()));
            }

        }catch (Exception e){
            // to close
            if (in != null){
                try {
                    in.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
            in = null;

            if (out != null){
                try {
                    out.close();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
            out = null;

            try {
                this.socket.close();
            }catch (Exception e3){
                e3.printStackTrace();
            }
            this.socket = null;
        }


    }
}
