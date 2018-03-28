package me.kkang.tools.bridge_server.client.message;

public enum ClientMessageAction {
    REGISTER("register");

    private String action;

    ClientMessageAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
