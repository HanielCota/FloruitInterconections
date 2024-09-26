package com.floruit.floruitInterconections.listener;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.event.EventHandler;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChatEvent(ChatEvent event) {
        if (!isValidEvent(event)) {
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) event.getSender();
        String message = event.getMessage();

        if (!isConnectCommand(message)) {
            return;
        }

        event.setCancelled(true);

        String serverName = message.split(" ")[1];
        connectToServer(player, serverName);
    }

    private boolean isValidEvent(ChatEvent event) {
        return event != null
                && event.getSender() instanceof ProxiedPlayer
                && event.getMessage() != null;
    }

    private boolean isConnectCommand(String message) {
        return message.startsWith("/connectTo ");
    }

    private void connectToServer(ProxiedPlayer player, String serverName) {
        ServerInfo serverInfo = ProxyServer.getInstance().getServerInfo(serverName);

        if (serverInfo == null) {
            player.sendMessage(new TextComponent("§cServidor não encontrado."));
            return;
        }

        player.connect(serverInfo);
        player.sendMessage(new TextComponent("§aConectando ao servidor " + serverName + "..."));
    }
}
