package com.floruit.floruitInterconections;

import co.aikar.commands.BungeeCommandManager;
import com.floruit.floruitInterconections.commands.ServerListCommand;
import com.floruit.floruitInterconections.listener.PlayerChatListener;
import net.md_5.bungee.api.plugin.Plugin;

public class FloruitInterconectionsPlugin extends Plugin {

    private BungeeCommandManager commandManager;

    @Override
    public void onEnable() {
        initializeCommandManager();
        registerCommands();
        registerListeners();
    }

    private void initializeCommandManager() {
        commandManager = new BungeeCommandManager(this);
    }

    private void registerCommands() {
        commandManager.registerCommand(new ServerListCommand());
    }

    private void registerListeners() {
        if (getProxy() == null || getProxy().getPluginManager() == null) {
            getLogger().severe("ProxyServer ou PluginManager não estão disponíveis!");
            return;
        }
        getProxy().getPluginManager().registerListener(this, new PlayerChatListener());
    }
}
