package me.kkang.tools.bridge_server.client.message.handler.instance;

import me.kkang.tools.bridge_server.client.message.handler.ClientMessageHandler;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientRegisterMessage extends ClientMessageHandler {

    @Override
    public void handle(Socket socket) {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            

            out.writeUTF("OK");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    out = null;
                }
            }
        }

    }
}
