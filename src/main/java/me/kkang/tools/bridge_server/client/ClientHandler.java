package me.kkang.tools.bridge_server.socket;

import com.alibaba.fastjson.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket client) {
        socket = client;
    }

    public void run() {
        try {
            while (true){
                // 读取客户端数据
                DataInputStream input = new DataInputStream(socket.getInputStream());
                String clientInputStr = input.readUTF();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
                ClientMessage clientMessage = JSONObject.parseObject(clientInputStr, ClientMessage.class);
                ClientMessageHandler.handler(clientMessage).handle(socket);

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(clientInputStr);
                out.close();
                input.close();
            }
        } catch (Exception e) {
            System.out.println("服务器 run 异常: " + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    socket = null;
                    System.out.println("服务端 finally 异常:" + e.getMessage());
                }
            }
        }
    }
}
