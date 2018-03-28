package me.kkang.tools.bridge_server.client.message.handler;

import me.kkang.tools.bridge_server.client.message.ClientMessage;
import me.kkang.tools.bridge_server.client.message.ClientMessageAction;
import me.kkang.tools.bridge_server.client.message.handler.instance.ClientRegisterMessage;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientMessageHandler {

    private static Map<String, ClientMessageHandler> handlers = new HashMap<>();

    static {
        handlers.put(ClientMessageAction.REGISTER.getAction(), new ClientRegisterMessage());
    }

    public static ClientMessageHandler handler(ClientMessage clientMessage) {
        switch (clientMessage.getAction()) {
            case "register":
                return handlers.get(ClientMessageAction.REGISTER.getAction());
        }
        return null;
    }

    public void handle(Socket socket) {
    }
}
