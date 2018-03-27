package me.kkang.tools.bridge_server.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.ServerSocket;

@Component
public class Server {

    private static Logger logger = LoggerFactory.getLogger(Server.class);

    private static ServerSocket serverSocket;

    @Value("${socket.port:12345}")
    private int port;
    @Autowired
    private HandlerManager handlerManager;

    public void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(port);

                    logger.info("socket监听启动在端口：{}", port);
                    while (true) {
                        handlerManager.handleClient(serverSocket.accept());
                    }
                } catch (Exception e) {
                    logger.error("服务器异常: " + e.getMessage(), e);
                }
            }
        }).start();
    }


}