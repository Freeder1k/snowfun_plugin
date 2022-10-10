package com.hamfred.snowfun;

import org.bukkit.plugin.java.JavaPlugin;

public class Snowfun extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("ping").setExecutor(new PingCommand());

        getLogger().info("Have fun playing in the snow!");
    }

    @Override
    public void onDisable() {
        getLogger().info("It was fun playing in the snow!");
    }
}
