package com.floruit.floruitInterconections.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Comparator;

@CommandAlias("servers")
@Description("Lista todos os servidores disponíveis e permite conexão")
public class ServerListCommand extends BaseCommand {

    @Default
    public void onServerList(ProxiedPlayer player) {
        if (player == null) {
            return;
        }

        if (isServerListEmpty()) {
            player.sendMessage(new TextComponent("§cNenhum servidor disponível no momento."));
            return;
        }

        sendAvailableServersHeader(player);
        sendAvailableServers(player);
        sendEmptyLine(player);
    }

    private boolean isServerListEmpty() {
        return ProxyServer.getInstance() == null || ProxyServer.getInstance().getServers().isEmpty();
    }

    private void sendAvailableServersHeader(ProxiedPlayer player) {
        player.sendMessage(new TextComponent("§e§lSERVIDORES DISPONÍVEIS"));
        sendEmptyLine(player);
    }

    private void sendAvailableServers(ProxiedPlayer player) {
        ProxyServer.getInstance().getServers().values().stream()
                .sorted(Comparator.comparing(serverInfo -> serverInfo.getName().toLowerCase()))
                .forEach(serverInfo -> {
                    if (serverInfo.getName() == null) {
                        return;
                    }
                    String serverName = capitalizeServerName(serverInfo.getName());
                    TextComponent serverComponent = new TextComponent("§f[IR] §l" + serverName);
                    serverComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/connectTo " + serverInfo.getName()));
                    player.sendMessage(serverComponent);
                });
    }

    private String capitalizeServerName(String serverName) {
        if (serverName == null || serverName.isEmpty()) {
            return serverName;
        }
        return serverName.substring(0, 1).toUpperCase() + serverName.substring(1);
    }

    private void sendEmptyLine(ProxiedPlayer player) {
        player.sendMessage(new TextComponent(""));
    }
}
