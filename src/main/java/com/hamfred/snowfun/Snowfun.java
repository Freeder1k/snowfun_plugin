package com.hamfred.snowfun;

import org.bukkit.plugin.java.JavaPlugin;

public class Snowfun extends JavaPlugin {
    private final PlayerListener playerListener = new PlayerListener(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(playerListener, this);

        getCommand("ping").setExecutor(new PingCommand());
        getCommand("launcher").setExecutor(new LauncherCommand(this));

        getLogger().info("Have fun playing in the snow!");
    }

    @Override
    public void onDisable() {
        getLogger().info("See you next time!");
    }
}