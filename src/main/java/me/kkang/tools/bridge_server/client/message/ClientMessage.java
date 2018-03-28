package me.kkang.tools.bridge_server.client.message;

/**
 * client 发向 server 交互的信息封装
 */
public class ClientMessage {

    private String clientName;
    private String action;
    private String body;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
