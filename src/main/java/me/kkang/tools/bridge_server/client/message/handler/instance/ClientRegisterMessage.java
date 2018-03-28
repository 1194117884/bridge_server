package me.kkang.tools.bridge_server.client.message.handler.instance;

import me.kkang.tools.bridge_server.client.message.handler.ClientMessageHandler;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientRegisterMessage extends ClientMessageHandler {

    @Override
    public void handle(Socket socket) {
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("OK");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
