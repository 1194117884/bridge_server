package me.kkang.tools.bridge_server.client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static final String IP_ADDR = "127.0.0.1";//服务器地址
    public static final int PORT = 12345;//服务器端口号    

    public static void main(String[] args) {
        System.out.println("客户端启动...");
        //创建一个流套接字并将其连接到指定主机上的指定端口号
        Socket socket = null;
        try {
            socket = new Socket(IP_ADDR, PORT);
        } catch (IOException e) {

        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    socket = null;
                    System.out.println("客户端 finally 异常:" + e.getMessage());
                }
            }
        }

        int i = 0;
        while (i < 10) {
            try {
                i++;
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                //向服务器端发送数据
                out.println("asdfasdf");
                out.flush();
                out.close();
            } catch (Exception e) {
                System.out.println("客户端异常:" + e.getMessage());
            } finally {
            }
        }
    }

    private static PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }

    private static BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

}