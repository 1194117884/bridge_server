package me.kkang.tools.bridge_server.server;

import me.kkang.tools.bridge_server.client.ClientHandler;
import me.kkang.tools.bridge_server.worker.ThreadWorkerPool;
import org.springframework.stereotype.Component;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

@Component
public class HandlerManager {

    private static Map<String, Socket> online = new HashMap<>();

    public void handleClient(Socket client) {
        ThreadWorkerPool.execute(new ClientHandler(client));
    }
}