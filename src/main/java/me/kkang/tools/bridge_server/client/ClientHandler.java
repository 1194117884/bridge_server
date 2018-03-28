package me.kkang.tools.bridge_server.client;

import com.alibaba.fastjson.JSONObject;
import me.kkang.tools.bridge_server.client.message.ClientMessage;
import me.kkang.tools.bridge_server.client.message.handler.ClientMessageHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket client) {
        socket = client;
    }

    public void run() {
        try {
            while (true) {
                // 读取客户端数据
                BufferedReader input =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String answer = input.readLine();
                System.out.println(answer);
                ClientMessage clientMessage = JSONObject.parseObject(answer, ClientMessage.class);

                ClientMessageHandler.handler(clientMessage).handle(socket);
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
